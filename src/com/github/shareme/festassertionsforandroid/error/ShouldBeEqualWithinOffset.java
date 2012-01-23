/*
 * Created on Oct 24, 2010
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
package com.github.shareme.festassertionsforandroid.error;

import com.github.shareme.festassertionsforandroid.data.Offset;

/**
 * Creates an error message indicating that an assertion that verifies that two numbers are equal within a positive
 * offset failed.
 *
 * @author Alex Ruiz
 */
public class ShouldBeEqualWithinOffset extends BasicErrorMessageFactory {

  /**
   * Creates a new <code>{@link ShouldBeEqualWithinOffset}</code>.
   * @param <T> guarantees that the values used in this factory have the same type.
   * @param actual the actual value in the failed assertion.
   * @param expected the expected value in the failed assertion.
   * @param offset the given positive offset.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static <T extends Number> ErrorMessageFactory shouldBeEqual(T actual, T expected, Offset<T> offset) {
    return new ShouldBeEqualWithinOffset(actual, expected, offset);
  }

  private ShouldBeEqualWithinOffset(Number actual, Number expected, Offset<?> offset) {
    super("expected:<%s> but was:<%s> within offset:<%s>", expected, actual, offset.value);
  }
}
