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
package com.github.shareme.festassertionsforandroid.data;

import static com.github.shareme.festutilitiesandroid.Objects.HASH_CODE_PRIME;

/**
 * An index.
 *
 * @author Alex Ruiz
 */
public class Index {

  /** The value of this index. */
  public final int value;

  /**
   * Creates a new <code>{@link Index}</code>.
   * @param index the value of the index.
   * @return the created <code>Index</code>.
   * @throws IllegalArgumentException if the given value is negative.
   */
  public static Index atIndex(int index) {
    if (index < 0) throw new IllegalArgumentException("The value of the index should not be negative");
    return new Index(index);
  }

  private Index(int value) {
    this.value = value;
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Index other = (Index) obj;
    return value == other.value;
  }

  @Override public int hashCode() {
    int result = 1;
    result = HASH_CODE_PRIME * result + value;
    return result;
  }

  @Override public String toString() {
    return String.format("%s[value=%d]", getClass().getSimpleName(), value);
  }
}
