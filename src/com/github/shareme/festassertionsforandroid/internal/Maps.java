/*
 * Created on Dec 21, 2010
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
 * Copyright @2010-2011 the original author or authors.
 */
package com.github.shareme.festassertionsforandroid.internal;

import static com.github.shareme.festassertionsforandroid.error.ShouldNotContain.shouldNotContain;
import static com.github.shareme.festassertionsforandroid.error.ShouldContain.shouldContain;
import static com.github.shareme.festassertionsforandroid.error.ShouldHaveSize.shouldHaveSize;
import static com.github.shareme.festassertionsforandroid.error.ShouldNotBeEmpty.shouldNotBeEmpty;
import static com.github.shareme.festassertionsforandroid.error.ShouldBeEmpty.shouldBeEmpty;
import static com.github.shareme.festassertionsforandroid.error.ShouldBeNullOrEmpty.shouldBeNullOrEmpty;
import static com.github.shareme.festutilitiesandroid.Objects.areEqual;

import java.util.*;

import com.github.shareme.festassertionsforandroid.core.AssertionInfo;
import com.github.shareme.festassertionsforandroid.data.MapEntry;
import com.github.shareme.festutilitiesandroid.VisibleForTesting;

/**
 * Reusable assertions for <code>{@link Map}</code>s.
 *
 * @author Alex Ruiz
 */
public class Maps {

  private static Maps INSTANCE = new Maps();

  /**
   * Returns the singleton instance of this class.
   * @return the singleton instance of this class.
   */
  public static Maps instance() {
    return INSTANCE ;
  }

  @VisibleForTesting Failures failures = Failures.instance();

  @VisibleForTesting Maps() {}

  /**
   * Asserts that the given {@code Map} is {@code null} or empty.
   * @param info contains information about the assertion.
   * @param actual the given map.
   * @throws AssertionError if the given {@code Map} is not {@code null} *and* contains one or more entries.
   */
  public void assertNullOrEmpty(AssertionInfo info, Map<?, ?> actual) {
    if (actual == null || actual.isEmpty()) return;
    throw failures.failure(info, shouldBeNullOrEmpty(actual));
  }

  /**
   * Asserts that the given {@code Map} is empty.
   * @param info contains information about the assertion.
   * @param actual the given {@code Map}.
   * @throws AssertionError if the given {@code Map} is {@code null}.
   * @throws AssertionError if the given {@code Map} is not empty.
   */
  public void assertEmpty(AssertionInfo info, Map<?, ?> actual) {
    assertNotNull(info, actual);
    if (actual.isEmpty()) return;
    throw failures.failure(info, shouldBeEmpty(actual));
  }

  /**
   * Asserts that the given {@code Map} is not empty.
   * @param info contains information about the assertion.
   * @param actual the given {@code Map}.
   * @throws AssertionError if the given {@code Map} is {@code null}.
   * @throws AssertionError if the given {@code Map} is empty.
   */
  public void assertNotEmpty(AssertionInfo info, Map<?, ?> actual) {
    assertNotNull(info, actual);
    if (!actual.isEmpty()) return;
    throw failures.failure(info, shouldNotBeEmpty());
  }

  /**
   * Asserts that the number of entries in the given {@code Map} is equal to the expected one.
   * @param info contains information about the assertion.
   * @param actual the given {@code Map}.
   * @param expectedSize the expected size of {@code actual}.
   * @throws AssertionError if the given {@code Map} is {@code null}.
   * @throws AssertionError if the number of entries in the given {@code Map} is different than the expected one.
   */
  public void assertHasSize(AssertionInfo info, Map<?, ?> actual, int expectedSize) {
    assertNotNull(info, actual);
    int sizeOfActual = actual.size();
    if (sizeOfActual == expectedSize) return;
    throw failures.failure(info, shouldHaveSize(actual, sizeOfActual, expectedSize));
  }

  /**
   * Asserts that the given {@code Map} contains the given entries, in any order.
   * @param info contains information about the assertion.
   * @param actual the given {@code Map}.
   * @param entries the entries that are expected to be in the given {@code Map}.
   * @throws NullPointerException if the array of entries is {@code null}.
   * @throws IllegalArgumentException if the array of entries is empty.
   * @throws NullPointerException if any of the entries in the given array is {@code null}.
   * @throws AssertionError if the given {@code Map} is {@code null}.
   * @throws AssertionError if the given {@code Map} does not contain the given entries.
   */
  public void assertContains(AssertionInfo info, Map<?, ?> actual, MapEntry[] entries) {
    isNotEmptyOrNull(entries);
    assertNotNull(info, actual);
    Set<MapEntry> notFound = new LinkedHashSet<MapEntry>();
    for (MapEntry entry : entries) if (!containsEntry(actual, entry)) notFound.add(entry);
    if (notFound.isEmpty()) return;
    throw failures.failure(info, shouldContain(actual, entries, notFound));
  }

  /**
   * Asserts that the given {@code Map} does not contain the given entries.
   * @param info contains information about the assertion.
   * @param actual the given {@code Map}.
   * @param entries the entries that are expected to be in the given {@code Map}.
   * @throws NullPointerException if the array of entries is {@code null}.
   * @throws IllegalArgumentException if the array of entries is empty.
   * @throws NullPointerException if any of the entries in the given array is {@code null}.
   * @throws AssertionError if the given {@code Map} is {@code null}.
   * @throws AssertionError if the given {@code Map} contains any of the given entries.
   */
  public void assertDoesNotContain(AssertionInfo info, Map<?, ?> actual, MapEntry[] entries) {
    isNotEmptyOrNull(entries);
    assertNotNull(info, actual);
    Set<MapEntry> found = new LinkedHashSet<MapEntry>();
    for (MapEntry entry : entries) if (containsEntry(actual, entry)) found.add(entry);
    if (found.isEmpty()) return;
    throw failures.failure(info, shouldNotContain(actual, entries, found));
  }

  private void isNotEmptyOrNull(MapEntry[] entries) {
    if (entries == null) throw new NullPointerException("The array of entries to look for should not be null");
    if (entries.length == 0) throw new IllegalArgumentException("The array of entries to look for should not be empty");
  }

  private boolean containsEntry(Map<?, ?> actual, MapEntry entry) {
    if (entry == null) throw new NullPointerException("Entries to look for should not be null");
    if (!actual.containsKey(entry.key)) return false;
    return areEqual(actual.get(entry.key), entry.value);
  }

  private void assertNotNull(AssertionInfo info, Map<?, ?> actual) {
    Objects.instance().assertNotNull(info, actual);
  }
}
