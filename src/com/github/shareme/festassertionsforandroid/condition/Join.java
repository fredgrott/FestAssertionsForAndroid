/*
 * Created on Feb 6, 2011
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
package com.github.shareme.festassertionsforandroid.condition;

import static java.util.Collections.unmodifiableCollection;

import java.util.*;

import com.github.shareme.festassertionsforandroid.core.Condition;
import com.github.shareme.festutilitiesandroid.VisibleForTesting;

/**
 * Join of two or more <code>{@link Condition}</code>s.
 * @param <T> the type of object this condition accepts.
 *
 * @author Yvonne Wang
 */
public abstract class Join<T> extends Condition<T> {

  @VisibleForTesting final Collection<Condition<T>> conditions;

  /**
   * Creates a new </code>{@link Join}</code>.
   * @param conditions the conditions to join.
   * @throws NullPointerException if the given array is {@code null}.
   * @throws NullPointerException if any of the elements in the given array is {@code null}.
   */
  protected Join(Condition<T>...conditions) {
    this.conditions = listWithoutNulls(conditions);
  }

  private static <T> List<Condition<T>> listWithoutNulls(Condition<T>...conditions) {
    if (conditions == null) throw conditionsIsNull();
    List<Condition<T>> list = new ArrayList<Condition<T>>();
    for (Condition<T> condition : conditions) list.add(notNull(condition));
    return list;
  }

  /**
   * Creates a new </code>{@link Join}</code>.
   * @param conditions the conditions to join.
   * @throws NullPointerException if the given collection is {@code null}.
   * @throws NullPointerException if any of the elements in the given collection is {@code null}.
   */
  protected Join(Collection<Condition<T>> conditions) {
    this.conditions = listWithoutNulls(conditions);
  }

  private static <T> List<Condition<T>> listWithoutNulls(Collection<Condition<T>> conditions) {
    if (conditions == null) throw conditionsIsNull();
    List<Condition<T>> list = new ArrayList<Condition<T>>();
    for (Condition<T> condition : conditions) list.add(notNull(condition));
    return list;
  }

  private static NullPointerException conditionsIsNull() {
    return new NullPointerException("The given conditions should not be null");
  }

  private static <T> Condition<T> notNull(Condition<T> condition) {
    if (condition == null) throw new NullPointerException("The given conditions should not have null entries");
    return condition;
  }

  /**
   * Returns the conditions to join.
   * @return the conditions to join.
   */
  protected final Collection<Condition<T>> conditions() {
    return unmodifiableCollection(conditions);
  }
}
