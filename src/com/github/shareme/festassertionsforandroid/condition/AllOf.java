/*
 * Created on Feb 7, 2011
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

import java.util.Collection;

import com.github.shareme.festassertionsforandroid.core.Condition;

/**
 * Returns {@code true} if all of the joined conditions is satisfied.
 * @param <T> the type of object this condition accepts.
 *
 * @author Yvonne Wang
 */
public class AllOf<T> extends Join<T> {

  /**
   * Creates a new <code>{@link AllOf}</code>
   * @param <T> the type of object the given condition accept.
   * @param conditions the conditions to evaluate.
   * @return the created {@code AnyOf}.
   * @throws NullPointerException if the given array is {@code null}.
   * @throws NullPointerException if any of the elements in the given array is {@code null}.
   */
  public static <T> Condition<T> allOf(Condition<T>...conditions) {
    return new AllOf<T>(conditions);
  }

  /**
   * Creates a new <code>{@link AllOf}</code>
   * @param <T> the type of object the given condition accept.
   * @param conditions the conditions to evaluate.
   * @return the created {@code AnyOf}.
   * @throws NullPointerException if the given collection is {@code null}.
   * @throws NullPointerException if any of the elements in the given collection is {@code null}.
   */
  public static <T> Condition<T> allOf(Collection<Condition<T>> conditions) {
    return new AllOf<T>(conditions);
  }

  private AllOf(Condition<T>...conditions) {
    super(conditions);
  }

  private AllOf(Collection<Condition<T>> conditions) {
    super(conditions);
  }

  /** {@inheritDoc} */
  @Override public boolean matches(T value) {
    for (Condition<T> condition : conditions)
      if (!condition.matches(value)) return false;
    return true;
  }

  @Override public String toString() {
    return String.format("all of:<%s>", conditions);
  }
}
