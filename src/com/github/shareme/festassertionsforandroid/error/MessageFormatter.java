/*
 * Created on Sep 8, 2010
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

import static com.github.shareme.festutilitiesandroid.ToString.toStringOf;

import com.github.shareme.festassertionsforandroid.description.Description;
import com.github.shareme.festutilitiesandroid.*;

/**
 * Formats the messages to be included in assertion errors.
 *
 * @author Alex Ruiz
 */
public class MessageFormatter {

  private static final MessageFormatter INSTANCE = new MessageFormatter();

  /**
   * Returns the singleton instance of this class.
   * @return the singleton instance of this class.
   */
  public static MessageFormatter instance() {
    return INSTANCE;
  }

  @VisibleForTesting DescriptionFormatter descriptionFormatter = DescriptionFormatter.instance();

  @VisibleForTesting MessageFormatter() {}

  /**
   * Interprets a printf-style format {@code String} for failed assertion messages. It is similar to
   * <code>{@link String#format(String, Object...)}</code>, except for:
   * <ol>
   * <li>the value of the given <code>{@link Description}</code> is used as the first argument referenced in the format
   * string</li>
   * <li>each of the arguments in the given array is converted to a {@code String} by invoking
   * <code>{@link ToString#toStringOf(Object)}</code>.
   * </ol>
   * @param d the description of the failed assertion, may be {@code null}.
   * @param format the format string.
   * @param args arguments referenced by the format specifiers in the format string.
   * @throws NullPointerException if the format string is {@code null}.
   * @return A formatted {@code String}.
   */
  public String format(Description d, String format, Object... args) {
    if (format == null) throw new NullPointerException("The format string should not be null");
    if (args == null) throw new NullPointerException("The array of arguments should not be null");
    return descriptionFormatter.format(d) + String.format(format, format(args));
  }

  private Object[] format(Object[] args) {
    int argCount = args.length;
    String[] formatted = new String[argCount];
    for (int i = 0; i < argCount; i++)
      formatted[i] = asText(args[i]);
    return formatted;
  }

  private String asText(Object o) {
    return toStringOf(o);
  }
}
