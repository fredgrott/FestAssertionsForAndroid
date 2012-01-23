/*
 * Created on Nov 20, 2010
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

import com.github.shareme.festassertionsforandroid.data.Index;

/**
 * Creates an error message indicating that an assertion that verifies a group of elements contains a value at a given
 * index failed. A group of elements can be a collection, an array or a {@code String}.
 *
 * @author Alex Ruiz
 */
public class ShouldContainAtIndex extends BasicErrorMessageFactory {

  /**
   * Creates a new </code>{@link ShouldContainAtIndex}</code>.
   * @param actual the actual value in the failed assertion.
   * @param expected value expected to be in {@code actual}.
   * @param index the index of the expected value.
   * @param found the value in {@code actual} stored under {@code index}.
   * @return the created {@code ErrorMessageFactory}.
   */
  public static ErrorMessageFactory shouldContainAtIndex(Object actual, Object expected, Index index, Object found) {
    return new ShouldContainAtIndex(actual, expected, index, found);
  }

  private ShouldContainAtIndex(Object actual, Object expected, Index index, Object found) {
    super("expecting <%s> at index <%s> but found <%s> in <%s>", expected, index.value, found, actual);
  }
}
