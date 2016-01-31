/**
 * Copyright (c) 2015 the original author or authors
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

/**
 * A convenient class for instantiating the Trie tries.
 *
 * @author Jakub Narloch
 */
public final class Tries {

    /**
     * Creates new instances of {@link Tries}.
     *
     * Private constructor prevents from instantation outside this class.
     */
    private Tries() {
        // empty constructor
    }

    /**
     * Creates new instance of {@link ArrayTrie}.
     *
     * @param <T> the element type
     * @return the instance of {@link ArrayTrie}
     */
    public static <T> ArrayTrie<T> newArrayTrie() {
        return new ArrayTrie<T>();
    }

    /**
     * Creates new instance of {@link ArrayTrie} with node capacity. The capacity specifies how many distinct
     * characters can be stored by individual node, for instance to map only ASCII characters specify the capacity
     * of 128, in case of extended ASCII - 256.
     *
     * @param <T>      the element type
     * @param capacity the trie node character capacity
     * @return the instance of {@link ArrayTrie}
     */
    public static <T> ArrayTrie<T> newArrayTrie(int capacity) {
        return new ArrayTrie<T>(capacity);
    }

    /**
     * Creates new instance of {@link TroveCharHashMapTrie}.
     *
     * @param <T> the element type
     * @return the instance of {@link TroveCharHashMapTrie}
     */
    public static <T> TroveCharHashMapTrie<T> newTroveCharHashMapTrie() {
        return new TroveCharHashMapTrie<T>();
    }

    /**
     * Creates new instance of {@link TroveCharHashMapTrie} with initial capacity.
     *
     * @param <T>             the element type
     * @param initialCapacity the initial capacity
     * @return the instance of {@link TroveCharHashMapTrie}
     */
    public static <T> TroveCharHashMapTrie<T> newTroveCharHashMapTrie(int initialCapacity) {
        return new TroveCharHashMapTrie<T>(initialCapacity);
    }

    /**
     * Creates new instance of {@link TroveCharHashMapTrie} with initial capacity and load factor.
     *
     * @param <T>             the element type
     * @param initialCapacity the initial capacity
     * @param loadFactor      the load factor
     * @return the instance of {@link TroveCharHashMapTrie}
     */
    public static <T> TroveCharHashMapTrie<T> newTroveCharHashMapTrie(int initialCapacity, float loadFactor) {
        return new TroveCharHashMapTrie<T>(initialCapacity, loadFactor);
    }

    /**
     * Creates new instance of {@link KolobokeCharHashMapTrie}.
     *
     * @param <T> the element type
     * @return the instance of {@link KolobokeCharHashMapTrie}
     */
    public static <T> KolobokeCharHashMapTrie<T> newKolobokeCharHashMapTrie() {
        return new KolobokeCharHashMapTrie<T>();
    }

    /**
     * Creates new instance of {@link KolobokeCharHashMapTrie} with expected size.
     *
     * @param <T>             the element type
     * @param expectedSize the expected size
     * @return the instance of {@link TroveCharHashMapTrie}
     */
    public static <T> KolobokeCharHashMapTrie<T> newKolobokeCharHashMapTrie(int expectedSize) {
        return new KolobokeCharHashMapTrie<T>(expectedSize);
    }

    /**
     * Creates new instance of {@link HashMapTrie}.
     *
     * @param <T> the element type
     * @return the instance of {@link HashMapTrie}
     */
    public static <T> HashMapTrie<T> newHashMapTrie() {
        return new HashMapTrie<T>();
    }

    /**
     * Creates new instance of {@link HashMapTrie} with initial capacity.
     *
     * @param <T>             the element type
     * @param initialCapacity the initial capacity
     * @return the instance of {@link HashMapTrie}
     */
    public static <T> HashMapTrie<T> newHashMapTrie(int initialCapacity) {
        return new HashMapTrie<T>(initialCapacity);
    }

    /**
     * Creates new instance of {@link HashMapTrie} with initial capacity and load factor.
     *
     * @param <T>             the element type
     * @param initialCapacity the initial capacity
     * @param loadFactor      the load factor
     * @return the instance of {@link HashMapTrie}
     */
    public static <T> HashMapTrie<T> newHashMapTrie(int initialCapacity, float loadFactor) {
        return new HashMapTrie<T>(initialCapacity, loadFactor);
    }
}
