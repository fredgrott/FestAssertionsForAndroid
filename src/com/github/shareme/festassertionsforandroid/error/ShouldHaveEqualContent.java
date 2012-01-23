/*
 * Created on Jan 28, 2011
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
package com.github.shareme.festassertionsforandroid.error;

import static com.github.shareme.festutilitiesandroid.Systems.LINE_SEPARATOR;

import java.io.File;
import java.util.List;

/**
 * Creates an error message indicating that an assertion that verifies that two files have equal content failed.
 *
 * @author Yvonne Wang
 */
public class ShouldHaveEqualContent extends BasicErrorMessageFactory {

  /**
   * Creates a new <code>{@link ShouldHaveEqualContent}</code>.
   * @param actual the actual file in the failed assertion.
   * @param expected the expected file in the failed assertion.
   * @param diffs the differences between {@code actual} and {@code expected}.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldHaveEqualContent(File actual, File expected, List<String> diffs) {
    StringBuilder b = new StringBuilder();
    for (String diff : diffs)
      b.append(LINE_SEPARATOR).append(diff);
    return new ShouldHaveEqualContent(actual, expected, b.toString());
  }

  private ShouldHaveEqualContent(File actual, File expected, String diffs) {
    super("file:<%s> and file:<%s> do not have equal content:" + diffs, actual, expected);
  }
}
