/*
 * Created on Feb 3, 2011
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

/**
 * Creates an error message indicating that an assertion that verifies that a value is in a
 * group of values (e.g. an array or collection) failed.
 *
 * @author Yvonne Wang
 */
public class ShouldBeIn extends BasicErrorMessageFactory {

  /**
   * Creates a new <code>{@link ShouldBeIn}</code>.
   * @param actual the actual value in the failed assertion.
   * @param values the group of values where {@code actual} is expected to be in.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldBeIn(Object actual, Object values) {
    return new ShouldBeIn(actual, values);
  }

  private ShouldBeIn(Object actual, Object values) {
    super("expecting:<%s> to be in:<%s>", actual, values);
  }
}
