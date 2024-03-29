/*
 * Created on Dec 21, 2010
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

import static com.github.shareme.festutilitiesandroid.Objects.*;
import static com.github.shareme.festutilitiesandroid.Strings.quote;

import java.util.Map;

/**
 * Understands an entry in a <code>{@link Map}</code>.
 *
 * @author Yvonne Wang
 */
public class MapEntry {

  /** The key corresponding to this entry. */
  public final Object key;

  /** The value corresponding to this entry. */
  public final Object value;

  /**
   * Creates a new map entry.
   * @param key the key of the entry to create.
   * @param value the value of the entry to create.
   * @return the created map entry.
   */
  public static MapEntry entry(Object key, Object value) {
    return new MapEntry(key, value);
  }

  private MapEntry(Object key, Object value) {
    this.key = key;
    this.value = value;
  }

  @Override public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    MapEntry other = (MapEntry) obj;
    if (!areEqual(key, other.key)) return false;
    return areEqual(value, other.value);
  }

  @Override public int hashCode() {
    int result = 1;
    result = HASH_CODE_PRIME * result + hashCodeFor(key);
    result = HASH_CODE_PRIME * result + hashCodeFor(value);
    return result;
  }

  @Override public String toString() {
    return String.format("%s[key=%s, value=%s]", getClass().getSimpleName(), quote(key), quote(value));
  }
}
