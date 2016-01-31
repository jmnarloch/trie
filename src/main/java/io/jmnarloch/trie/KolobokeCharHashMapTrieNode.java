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

import gnu.trove.map.TCharObjectMap;
import net.openhft.koloboke.collect.map.hash.HashCharObjMap;
import net.openhft.koloboke.collect.map.hash.HashCharObjMaps;

/**
 * A Koloboke {@link TCharObjectMap} backed Trie node.
 *
 * @author Jakub Narloch
 */
public class KolobokeCharHashMapTrieNode<T> extends AbstractTrieNode<T, KolobokeCharHashMapTrieNode<T>> {

    /**
     * The map of children nodes.
     */
    private final HashCharObjMap<KolobokeCharHashMapTrieNode<T>> next;

    /**
     * Creates new instance of {@link KolobokeCharHashMapTrieNode}.
     */
    public KolobokeCharHashMapTrieNode() {
        next = HashCharObjMaps.getDefaultFactory().newMutableMap();
    }

    /**
     * Creates new instance of {@link KolobokeCharHashMapTrieNode} with expected size.
     *
     * @param expectedSize the expected size
     */
    public KolobokeCharHashMapTrieNode(int expectedSize) {
        next = HashCharObjMaps.getDefaultFactory().newMutableMap(expectedSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNext(char c, KolobokeCharHashMapTrieNode<T> next) {
        this.next.put(c, next);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KolobokeCharHashMapTrieNode<T> getNext(char c) {
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
