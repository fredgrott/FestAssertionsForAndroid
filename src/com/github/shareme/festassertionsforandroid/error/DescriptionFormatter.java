/*
 * Created on Jan 11, 2011
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

import static com.github.shareme.festutilitiesandroid.Strings.isEmpty;

import com.github.shareme.festassertionsforandroid.description.Description;
import com.github.shareme.festutilitiesandroid.VisibleForTesting;

/**
 * Formats the <code>{@link Description}</code>s to be included in assertion errors.
 *
 * @author Alex Ruiz
 */
public class DescriptionFormatter {

  private static final DescriptionFormatter INSTANCE = new DescriptionFormatter();

  /**
   * Returns the singleton instance of this class.
   * @return the singleton instance of this class.
   */
  public static DescriptionFormatter instance() {
    return INSTANCE;
  }

  @VisibleForTesting DescriptionFormatter() {}

  /**
   * Formats the given <code>{@link Description}</code> by surrounding its text value with square brackets and adding a
   * space at the end.
   * @param d the description to format. It can be {@code null}.
   * @return the formatted description, or an empty {@code String} if the the {@code Description} is {@code null}.
   */
  public String format(Description d) {
    String s = (d != null) ? d.value() : null;
    if (isEmpty(s)) return "";
    return String.format("[%s] ", s);
  }
}
