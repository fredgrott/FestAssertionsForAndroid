/*
 * Created on Jan 26, 2011
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright @2011 the original author or authors.
 */
package com.github.shareme.festassertionsforandroid.internal;

import static com.github.shareme.festassertionsforandroid.error.ShouldBeAbsolutePath.shouldBeAbsolutePath;
import static com.github.shareme.festassertionsforandroid.error.ShouldBeDirectory.shouldBeDirectory;
import static com.github.shareme.festassertionsforandroid.error.ShouldBeFile.shouldBeFile;
import static com.github.shareme.festassertionsforandroid.error.ShouldBeRelativePath.shouldBeRelativePath;
import static com.github.shareme.festassertionsforandroid.error.ShouldExist.shouldExist;
import static com.github.shareme.festassertionsforandroid.error.ShouldHaveEqualContent.shouldHaveEqualContent;
import static com.github.shareme.festassertionsforandroid.error.ShouldNotExist.shouldNotExist;

import java.io.*;
import java.util.List;

import com.github.shareme.festassertionsforandroid.core.AssertionInfo;
import com.github.shareme.festutilitiesandroid.*;

/**
 * Reusable assertions for <code>{@link File}</code>s.
 *
 * @author David DIDIER
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class Files {

  private static final Files INSTANCE = new Files();

  /**
   * Returns the singleton instance of this class.
   * @return the singleton instance of this class.
   */
  public static Files instance() {
    return INSTANCE;
  }

  @VisibleForTesting Diff diff = new Diff();
  @VisibleForTesting Failures failures = Failures.instance();

  @VisibleForTesting Files() {}

  /**
   * Asserts that the given files have equal content. Adapted from
   * <a href="http://junit-addons.sourceforge.net/junitx/framework/FileAssert.html" target="_blank">FileAssert</a> (from
   * <a href="http://sourceforge.net/projects/junit-addons">JUnit-addons</a>.)
   * @param info contains information about the assertion.
   * @param actual the "actual" file.
   * @param expected the "expected" file.
   * @throws NullPointerException if {@code expected} is {@code null}.
   * @throws IllegalArgumentException if {@code expected} is not an existing file.
   * @throws AssertionError if {@code actual} is {@code null}.
   * @throws AssertionError if {@code actual} is not an existing file.
   * @throws FilesException if an I/O error occurs.
   * @throws AssertionError if the given files do not have equal content.
   */
  public void assertEqualContent(AssertionInfo info, File actual, File expected) {
    verifyIsFile(expected);
    assertIsFile(info, actual);
    try {
      List<String> diffs = diff.diff(actual, expected);
      if (diffs.isEmpty()) return;
      throw failures.failure(info, shouldHaveEqualContent(actual, expected, diffs));
    } catch (IOException e) {
      String msg = String.format("Unable to compare contents of files:<%s> and:<%s>", actual, expected);
      throw new FilesException(msg, e);
    }
  }

  private void verifyIsFile(File expected) {
    if (expected == null) throw new NullPointerException("The file to compare to should not be null");
    if (expected.isFile()) return;
    throw new IllegalArgumentException(String.format("Expected file:<'%s'> should be an existing file", expected));
  }

  /**
   * Asserts that the given file is an existing file.
   * @param info contains information about the assertion.
   * @param actual the given file.
   * @throws AssertionError if the given file is {@code null}.
   * @throws AssertionError if the given file is not an existing file.
   */
  public void assertIsFile(AssertionInfo info, File actual) {
    assertNotNull(info, actual);
    if (actual.isFile()) return;
    throw failures.failure(info, shouldBeFile(actual));
  }

  /**
   * Asserts that the given file is an existing directory.
   * @param info contains information about the assertion.
   * @param actual the given file.
   * @throws AssertionError if the given file is {@code null}.
   * @throws AssertionError if the given file is not an existing directory.
   */
  public void assertIsDirectory(AssertionInfo info, File actual) {
    assertNotNull(info, actual);
    if (actual.isDirectory()) return;
    throw failures.failure(info, shouldBeDirectory(actual));
  }

  /**
   * Asserts that the given file is an absolute path.
   * @param info contains information about the assertion.
   * @param actual the given file.
   * @throws AssertionError if the given file is {@code null}.
   * @throws AssertionError if the given file is not an absolute path.
   */
  public void assertIsAbsolute(AssertionInfo info, File actual) {
    if (isAbsolutePath(info, actual)) return;
    throw failures.failure(info, shouldBeAbsolutePath(actual));
  }

  /**
   * Asserts that the given file is a relative path.
   * @param info contains information about the assertion.
   * @param actual the given file.
   * @throws AssertionError if the given file is {@code null}.
   * @throws AssertionError if the given file is not a relative path.
   */
  public void assertIsRelative(AssertionInfo info, File actual) {
    if (!isAbsolutePath(info, actual)) return;
    throw failures.failure(info, shouldBeRelativePath(actual));
  }

  private boolean isAbsolutePath(AssertionInfo info, File actual) {
    assertNotNull(info, actual);
    return actual.isAbsolute();
  }

  /**
   * Asserts that the given file exists, regardless it's a file or directory.
   * @param info contains information about the assertion.
   * @param actual the given file.
   * @throws AssertionError if the given file is {@code null}.
   * @throws AssertionError if the given file does not exist.
   */
  public void assertExists(AssertionInfo info, File actual) {
    assertNotNull(info, actual);
    if (actual.exists()) return;
    throw failures.failure(info, shouldExist(actual));
  }

  /**
   * Asserts that the given file does not exist.
   * @param info contains information about the assertion.
   * @param actual the given file.
   * @throws AssertionError if the given file is {@code null}.
   * @throws AssertionError if the given file exists.
   */
  public void assertDoesNotExist(AssertionInfo info, File actual) {
    assertNotNull(info, actual);
    if (!actual.exists()) return;
    throw failures.failure(info, shouldNotExist(actual));
  }

  private static void assertNotNull(AssertionInfo info, File actual) {
    Objects.instance().assertNotNull(info, actual);
  }
}
