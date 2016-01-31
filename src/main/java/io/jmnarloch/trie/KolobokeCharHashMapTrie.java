/**
 * Copyright (c) 2015-2016 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jmnarloch.trie;

/**
 * A Trie tree backed by Koloboke's {@link gnu.trove.map.hash.TCharObjectHashMap}.
 *
 * @author Jakub Narloch
 */
public class KolobokeCharHashMapTrie<T> extends AbstractTrie<T, KolobokeCharHashMapTrieNode<T>> {

    /**
     * Creates new instance of {@link KolobokeCharHashMapTrie} class.
     */
    public KolobokeCharHashMapTrie() {
        super(new TrieNodeFactory<T, KolobokeCharHashMapTrieNode<T>>() {
            @Override
            public KolobokeCharHashMapTrieNode<T> createNode() {
                return new KolobokeCharHashMapTrieNode<T>();
            }
        });
    }

    /**
     * Creates new instance of {@link KolobokeCharHashMapTrie} class with initial capacity.
     *
     * @param expectedSize the initial capacity
     */
    public KolobokeCharHashMapTrie(final int expectedSize) {
        super(new TrieNodeFactory<T, KolobokeCharHashMapTrieNode<T>>() {
            @Override
            public KolobokeCharHashMapTrieNode<T> createNode() {
                return new KolobokeCharHashMapTrieNode<T>(expectedSize);
            }
        });
    }
}
