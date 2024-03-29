/*
 * Created on Aug 5, 2010
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

import com.github.shareme.festassertionsforandroid.description.Description;

/**
 * Factory of <code>{@link AssertionError}</code>s.
 *
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public interface AssertionErrorFactory {

  /**
   * Creates an <code>{@link AssertionError}</code>.
   * @param d the description of the failed assertion.
   * @return the created {@code AssertionError}.
   */
  AssertionError newAssertionError(Description d);
}
