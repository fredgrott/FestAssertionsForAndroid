/*
 * Created on Oct 18, 2010
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

import static java.lang.String.format;
import static com.github.shareme.festutilitiesandroid.Arrays.format;
import static com.github.shareme.festutilitiesandroid.Objects.*;
import static com.github.shareme.festutilitiesandroid.Strings.quote;

import java.util.Arrays;

import com.github.shareme.festassertionsforandroid.description.Description;
import com.github.shareme.festutilitiesandroid.VisibleForTesting;

/**
 * A factory of error messages typically shown when an assertion fails.
 *
 * @author Alex Ruiz
 */
public class BasicErrorMessageFactory implements ErrorMessageFactory {

  private final String format;
  private final Object[] arguments;

  @VisibleForTesting MessageFormatter formatter = MessageFormatter.instance();

  /**
   * Creates a new </code>{@link BasicErrorMessageFactory}</code>.
   * @param format the format string.
   * @param arguments arguments referenced by the format specifiers in the format string.
   */
  public BasicErrorMessageFactory(String format, Object... arguments) {
    this.format = format;
    this.arguments = arguments;
  }

  /** {@inheritDoc} */
  public String create(Description d) {
    return formatter.format(d, format, arguments);
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    BasicErrorMessageFactory other = (BasicErrorMessageFactory) obj;
    if (!areEqual(format, other.format)) return false;
    return Arrays.equals(arguments, other.arguments);
  }

  @Override public int hashCode() {
    int result = 1;
    result = HASH_CODE_PRIME * result + hashCodeFor(format);
    result = HASH_CODE_PRIME * result + Arrays.hashCode(arguments);
    return result;
  }

  @Override public String toString() {
    return format("%s[format=%s, arguments=%s]", getClass().getSimpleName(), quote(format), format(arguments));
  }
}
