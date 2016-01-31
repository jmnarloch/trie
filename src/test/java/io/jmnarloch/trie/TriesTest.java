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

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Tests the {@link Tries} class.
 *
 * @author Jakub Narloch
 */
public class TriesTest {

    @Test
    public void shouldCreateCharArrayTrie() {

        // when
        Trie<String> trie = Tries.newArrayTrie();

        // then
        assertNotNull(trie);
    }

    @Test
    public void shouldCreateCharArrayTrieWithCapacity() {

        // when
        Trie<String> trie = Tries.newArrayTrie(127);

        // then
        assertNotNull(trie);
    }

    @Test
    public void shouldCreateHashMapTrie() {

        // when
        Trie<String> trie = Tries.newHashMapTrie();

        // then
        assertNotNull(trie);
    }

    @Test
    public void shouldCreateHashMapTrieWithInitialCapacity() {

        // when
        Trie<String> trie = Tries.newHashMapTrie(8);

        // then
        assertNotNull(trie);
    }

    @Test
    public void shouldCreateHashMapTrieWithInitialCapacityAndLoadFactor() {

        // when
        Trie<String> trie = Tries.newHashMapTrie(8, 0.5f);

        // then
        assertNotNull(trie);
    }

    @Test
    public void shouldCreateTroveCharHashMapTrie() {

        // when
        Trie<String> trie = Tries.newTroveCharHashMapTrie();

        // then
        assertNotNull(trie);
    }

    @Test
    public void shouldCreateTroveCharHashMapTrieWithInitialCapacity() {

        // when
        Trie<String> trie = Tries.newTroveCharHashMapTrie(16);

        // then
        assertNotNull(trie);
    }

    @Test
    public void shouldCreateTroveCharHashMapTrieWithInitialCapacityAndLoadFactor() {

        // when
        Trie<String> trie = Tries.newTroveCharHashMapTrie(16, 0.75f);

        // then
        assertNotNull(trie);
    }

    @Test
    public void shouldCreateKolobokeCharHashMapTrie() {

        // when
        Trie<String> trie = Tries.newKolobokeCharHashMapTrie();

        // then
        assertNotNull(trie);
    }

    @Test
    public void shouldCreateKolobokeCharHashMapTrieWithInitialCapacity() {

        // when
        Trie<String> trie = Tries.newKolobokeCharHashMapTrie(16);

        // then
        assertNotNull(trie);
    }
}