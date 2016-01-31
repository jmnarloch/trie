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

/**
 * A character array backed Trie node.
 *
 * @author Jakub Narloch
 */
class ArrayTrieNode<T> extends AbstractTrieNode<T, ArrayTrieNode<T>> {

    /**
     * The number of distinct children - resembles the 2 byte char distinct values.
     */
    private static final int R = 0xffff;

    /**
     * The array of child nodes.
     */
    private ArrayTrieNode<T>[] next;

    /**
     * Creates new instance of {@link ArrayTrieNode} class.
     */
    public ArrayTrieNode() {
        this(R);
    }

    /**
     * Creates new instance of {@link ArrayTrieNode} class with specific capacity.
     *
     * @param capacity the maximum number of distinct characters stored by this node
     */
    @SuppressWarnings("unchecked")
    public ArrayTrieNode(int capacity) {
        if(capacity < 0 || capacity > R) {
            throw new IllegalArgumentException(String.format("Capacity exceeds bounds must be in range [0, %d]", R));
        }

        this.next = (ArrayTrieNode<T>[]) new ArrayTrieNode[capacity];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNext(char c, ArrayTrieNode<T> next) {
        this.next[getIndex(c)] = next;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ArrayTrieNode<T> getNext(char c) {
        if(!isValid(c)) {
            return null;
        }
        return next[getIndex(c)];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeNext(char c) {
        next[getIndex(c)] = null;
    }

    /**
     * Retrieves the code point of the given character.
     *
     * @param c the character
     * @return the character code point
     * @throws IllegalArgumentException if character exceeds the node capacity
     */
    private int getIndex(char c) {
        if(!isValid(c)) {
            throw new IllegalArgumentException(String.format("The character %c exceeds bounds.", c));
        }
        return c;
    }

    /**
     * Returns whether the character is in bounds for this node.
     *
     * @param c the character
     * @return true if character is in bounds
     */
    private boolean isValid(char c) {
        return c < next.length;
    }
}
