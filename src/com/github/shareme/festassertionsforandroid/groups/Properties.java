/*
 * Created on Feb 22, 2011
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
package com.github.shareme.festassertionsforandroid.groups;

import static com.github.shareme.festassertionsforandroid.util.ArrayWrapperList.wrap;

import java.util.*;

import com.github.shareme.festassertionsforandroid.internal.PropertySupport;
import com.github.shareme.festutilitiesandroid.*;

/**
 * Extracts the values of an specified property from the elements of a given <code>{@link Collection}</code> or array.
 *
 * @author Yvonne Wang
 */
public class Properties {

  @VisibleForTesting final String propertyName;

  @VisibleForTesting PropertySupport propertySupport = PropertySupport.instance();

  /**
   * Creates a new <code>{@link Properties}</code>.
   * @param propertyName the name of the property to be read from the elements of a {@code Collection}. It may be a
   * nested property (e.g. "address.street.number").
   * @throws NullPointerException if the given property name is {@code null}.
   * @throws IllegalArgumentException if the given property name is empty.
   * @return the created {@code Properties}.
   */
  public static Properties extractProperty(String propertyName) {
    checkIsNotNullOrEmpty(propertyName);
    return new Properties(propertyName);
  }

  private static void checkIsNotNullOrEmpty(String propertyName) {
    if (propertyName == null) throw new NullPointerException("The name of the property to read should not be null");
    if (propertyName.length() == 0)
      throw new IllegalArgumentException("The name of the property to read should not be empty");
  }

  @VisibleForTesting Properties(String propertyName) {
    this.propertyName = propertyName;
  }

}
