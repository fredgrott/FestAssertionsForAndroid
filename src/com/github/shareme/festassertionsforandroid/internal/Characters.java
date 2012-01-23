/*
 * Created on Oct 23, 2010
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

import static java.lang.Character.*;
import static com.github.shareme.festassertionsforandroid.error.ShouldBeEqual.shouldBeEqual;
import static com.github.shareme.festassertionsforandroid.error.ShouldBeGreater.shouldBeGreater;
import static com.github.shareme.festassertionsforandroid.error.ShouldBeGreaterOrEqual.shouldBeGreaterOrEqual;
import static com.github.shareme.festassertionsforandroid.error.ShouldBeLess.shouldBeLess;
import static com.github.shareme.festassertionsforandroid.error.ShouldBeLessOrEqual.shouldBeLessOrEqual;
import static com.github.shareme.festassertionsforandroid.error.ShouldBeLowerCase.shouldBeLowerCase;
import static com.github.shareme.festassertionsforandroid.error.ShouldBeUpperCase.shouldBeUpperCase;
import static com.github.shareme.festassertionsforandroid.error.ShouldNotBeEqual.shouldNotBeEqual;

import com.github.shareme.festassertionsforandroid.core.AssertionInfo;
import com.github.shareme.festutilitiesandroid.VisibleForTesting;

/**
 * Reusable assertions for <code>{@link Character}</code>s.
 *
 * @author Alex Ruiz
 */
public class Characters {

  private static final Characters INSTANCE = new Characters();

  /**
   * Returns the singleton instance of this class.
   * @return the singleton instance of this class.
   */
  public static Characters instance() {
    return INSTANCE;
  }

  @VisibleForTesting Failures failures = Failures.instance();

  @VisibleForTesting Characters() {}

  /**
   * Asserts that two characters are equal.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @param expected the expected value.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not equal to the expected one. This method will throw a
   * {@code org.junit.ComparisonFailure} instead if JUnit is in the classpath and the expected and actual values are not
   * equal.
   */
  public void assertEqual(AssertionInfo info, Character actual, char expected) {
    assertNotNull(info, actual);
    if (actual.charValue() == expected) return;
    throw failures.failure(info, shouldBeEqual(actual, expected));
  }

  /**
   * Asserts that two characters are not equal.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @param other the value to compare the actual value to.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is equal to the other one.
   */
  public void assertNotEqual(AssertionInfo info, Character actual, char other) {
    assertNotNull(info, actual);
    if (actual.charValue() != other) return;
    throw failures.failure(info, shouldNotBeEqual(actual, other));
  }

  /**
   * Asserts that the actual value is less than the other one.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @param other the value to compare the actual value to.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not less than the other one: this assertion will
   * fail if the actual value is equal to or greater than the other value.
   */
  public void assertLessThan(AssertionInfo info, Character actual, char other) {
    assertNotNull(info, actual);
    if (isLessThan(actual, other)) return;
    throw failures.failure(info, shouldBeLess(actual, other));
  }

  /**
   * Asserts that the actual value is less than or equal to the other one.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @param other the value to compare the actual value to.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is greater than the other one.
   */
  public void assertLessThanOrEqualTo(AssertionInfo info, Character actual, char other) {
    assertNotNull(info, actual);
    if (!isGreaterThan(actual, other)) return;
    throw failures.failure(info, shouldBeLessOrEqual(actual, other));
  }

  /**
   * Asserts that the actual value is greater than the other one.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @param other the value to compare the actual value to.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not greater than the other one: this assertion will
   * fail if the actual value is equal to or less than the other value.
   */
  public void assertGreaterThan(AssertionInfo info, Character actual, char other) {
    assertNotNull(info, actual);
    if (isGreaterThan(actual, other)) return;
    throw failures.failure(info, shouldBeGreater(actual, other));
  }

  private static boolean isGreaterThan(Character actual, char other) {
    return actual.charValue() > other;
  }

  /**
   * Asserts that the actual value is greater than or equal to the other one.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @param other the value to compare the actual value to.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is less than the other one.
   */
  public void assertGreaterThanOrEqualTo(AssertionInfo info, Character actual, char other) {
    assertNotNull(info, actual);
    if (!isLessThan(actual, other)) return;
    throw failures.failure(info, shouldBeGreaterOrEqual(actual, other));
  }

  private static boolean isLessThan(Character actual, char other) {
    return actual.charValue() < other;
  }

  /**
   * Asserts that the actual value is a lowercase character.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not a lowercase character.
   */
  public void assertLowerCase(AssertionInfo info, Character actual) {
    assertNotNull(info, actual);
    if (isLowerCase(actual)) return;
    throw failures.failure(info, shouldBeLowerCase(actual));
  }

  /**
   * Asserts that the actual value is a uppercase character.
   * @param info contains information about the assertion.
   * @param actual the actual value.
   * @throws AssertionError if the actual value is {@code null}.
   * @throws AssertionError if the actual value is not a uppercase character.
   */
  public void assertUpperCase(AssertionInfo info, Character actual) {
    assertNotNull(info, actual);
    if (isUpperCase(actual)) return;
    throw failures.failure(info, shouldBeUpperCase(actual));
  }

  private static void assertNotNull(AssertionInfo info, Character actual) {
    Objects.instance().assertNotNull(info, actual);
  }
}
