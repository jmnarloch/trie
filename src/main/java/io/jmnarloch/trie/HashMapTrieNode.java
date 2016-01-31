/**
 * Copyright (c) 2015-2016 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jmnarloch.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * A {@link HashMap} backed trie node.
 *
 * @author Jakub Narloch
 */
class HashMapTrieNode<T> extends AbstractTrieNode<T, HashMapTrieNode<T>> {

    /**
     * The {@link Map} of children nodes.
     */
    private final Map<Character, HashMapTrieNode<T>> next;

    /**
     * Creates new instance of {@link HashMapTrieNode}.
     */
    public HashMapTrieNode() {
        next = new HashMap<Character, HashMapTrieNode<T>>();
    }

    /**
     * Creates new instance of {@link HashMapTrieNode} with initial capacity.
     *
     * @param initialCapacity the initial capacity
     */
    public HashMapTrieNode(int initialCapacity) {
        next = new HashMap<Character, HashMapTrieNode<T>>(initialCapacity);
    }

    /**
     * Creates new instance of {@link HashMapTrieNode} with initial capacity.
     *
     * @param initialCapacity the initial capacity
     * @param loadFactor the load factor
     */
    public HashMapTrieNode(int initialCapacity, float loadFactor) {
        next = new HashMap<Character, HashMapTrieNode<T>>(initialCapacity, loadFactor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNext(char c, HashMapTrieNode<T> next) {
        this.next.put(c, next);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HashMapTrieNode<T> getNext(char c) {
        return next.get(c);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeNext(char c) {
        next.remove(c);
    }
}
