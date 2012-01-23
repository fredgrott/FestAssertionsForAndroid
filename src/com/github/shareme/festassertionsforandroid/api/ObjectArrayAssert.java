/*
 * Created on Jul 26, 2010
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
package com.github.shareme.festassertionsforandroid.api;

import com.github.shareme.festassertionsforandroid.core.*;
import com.github.shareme.festassertionsforandroid.data.Index;
import com.github.shareme.festassertionsforandroid.internal.ObjectArrays;
import com.github.shareme.festutilitiesandroid.VisibleForTesting;

/**
 * Assertion methods for arrays of objects.
 * <p>
 * To create an instance of this class, invoke <code>{@link Assertions#assertThat(Object[])}</code>.
 * </p>
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class ObjectArrayAssert extends AbstractAssert<ObjectArrayAssert, Object[]> implements
    ObjectEnumerableAssert<ObjectArrayAssert>, IndexedObjectEnumerableAssert {

  @VisibleForTesting ObjectArrays arrays = ObjectArrays.instance();

  protected ObjectArrayAssert(Object[] actual) {
    super(actual, ObjectArrayAssert.class);
  }

  /** {@inheritDoc} */
  public void isNullOrEmpty() {
    arrays.assertNullOrEmpty(info, actual);
  }

  /** {@inheritDoc} */
  public void isEmpty() {
    arrays.assertEmpty(info, actual);
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert isNotEmpty() {
    arrays.assertNotEmpty(info, actual);
    return this;
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert hasSize(int expected) {
    arrays.assertHasSize(info, actual, expected);
    return this;
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert contains(Object... values) {
    arrays.assertContains(info, actual, values);
    return this;
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert containsOnly(Object... values) {
    arrays.assertContainsOnly(info, actual, values);
    return this;
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert containsSequence(Object... sequence) {
    arrays.assertContainsSequence(info, actual, sequence);
    return this;
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert contains(Object value, Index index) {
    arrays.assertContains(info, actual, value, index);
    return this;
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert doesNotContain(Object value, Index index) {
    arrays.assertDoesNotContain(info, actual, value, index);
    return this;
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert doesNotContain(Object... values) {
    arrays.assertDoesNotContain(info, actual, values);
    return this;
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert doesNotHaveDuplicates() {
    arrays.assertDoesNotHaveDuplicates(info, actual);
    return this;
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert startsWith(Object... sequence) {
    arrays.assertStartsWith(info, actual, sequence);
    return this;
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert endsWith(Object... sequence) {
    arrays.assertEndsWith(info, actual, sequence);
    return this;
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert containsNull() {
    arrays.assertContainsNull(info, actual);
    return this;
  }

  /** {@inheritDoc} */
  public ObjectArrayAssert doesNotContainNull() {
    arrays.assertDoesNotContainNull(info, actual);
    return this;
  }
}
