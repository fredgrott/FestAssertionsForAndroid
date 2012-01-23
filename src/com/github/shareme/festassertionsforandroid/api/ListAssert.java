/*
 * Created on Oct 26, 2010
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

import java.util.List;

import com.github.shareme.festassertionsforandroid.core.IndexedObjectEnumerableAssert;
import com.github.shareme.festassertionsforandroid.data.Index;
import com.github.shareme.festassertionsforandroid.internal.Lists;
import com.github.shareme.festutilitiesandroid.VisibleForTesting;

/**
 * Assertion methods for <code>{@link List}</code>s.
 * <p>
 * To create an instance of this class, invoke <code>{@link Assertions#assertThat(List)}</code>.
 * </p>
 *
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class ListAssert extends AbstractCollectionAssert<ListAssert, List<?>> implements IndexedObjectEnumerableAssert {

  @VisibleForTesting Lists lists = Lists.instance();

  protected ListAssert(List<?> actual) {
    super(actual, ListAssert.class);
  }

  /** {@inheritDoc} */
  public ListAssert contains(Object value, Index index) {
    lists.assertContains(info, actual, value, index);
    return this;
  }

  /** {@inheritDoc} */
  public ListAssert doesNotContain(Object value, Index index) {
    lists.assertDoesNotContain(info, actual, value, index);
    return this;
  }
}
