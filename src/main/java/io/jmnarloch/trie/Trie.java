/**
 * Copyright (c) 2015-2016 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jmnarloch.trie;

import java.util.Map;
import java.util.Set;

/**
 * A trie tree abstraction. Trie is a R way tree that is designed for efficient string searches.
 *
 * @author Jakub Narloch
 */
public interface Trie<T> {

    /**
     * Returns whether the trie does not contain any entries.
     *
     * @return true if trie does not have any entries, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the total number of entries.
     *
     * @return the total number of entries
     */
    int size();

    /**
     * Associated the value with specific key.
     *
     * @param key   the key that the value will be associated
     * @param value the value to insert
     * @return the previous value associated with the specific key
     * @throws IllegalArgumentException if {@code key} is {@code null} or empty string
     */
    T put(String key, T value);

    /**
     * Inserts all of the values from the given Map one to one the key and values of the map into the entries in the
     * trie.
     *
     * @param map the map of key value pairs to insert
     * @throws IllegalArgumentException if {@code map} is {@code null}
     */
    void putAll(Map<String, ? extends T> map);

    /**
     * Returns whether the trie contains the specific key.
     *
     * @param key the key to search
     * @return true if key exists, false otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null} or empty string
     */
    boolean containsKey(String key);

    /**
     * Returns the values associated with the specific key, or {@code null} otherwise.
     *
     * @param key the key to search
     * @return the associated key value or {@code null} if nothing was found
     * @throws IllegalArgumentException if {@code key} is {@code null} or empty string
     */
    T get(String key);

    /**
     * Returns the value of the longest common prefix for specified key.
     *
     * Finds the within the stored keys the one that shares the longest common prefix with the passed key and returns
     * the value associated with the key.
     *
     * @param key the key to search
     * @return the prefix key value or {@code null} if nothing was found
     * @throws IllegalArgumentException if {@code key} is {@code null} or empty string
     */
    T prefix(String key);

    /**
     * Returns the key of the longest common prefix for specified key.
     *
     * Finds the within the stored keys the one that shares the longest common prefix with the passed key and returns
     * the key.
     *
     * @param key the key to search
     * @return the prefix key or {@code null} if nothing was found
     * @throws IllegalArgumentException if {@code key} is {@code null} or empty string
     */
    String prefixKey(String key);

    /**
     * Removes the value associated with specific key.
     *
     * @param key the key to remove
     * @return the removed value associated with the specific key, or null if no entry existed for given key
     * @throws IllegalArgumentException if {@code key} is {@code null} or empty string
     */
    T remove(String key);

    /**
     * Returns all keys in the trie.
     *
     * @return all keys in the trie
     */
    Set<String> keySet();
}
