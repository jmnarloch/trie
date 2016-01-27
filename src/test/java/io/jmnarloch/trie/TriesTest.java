/**
 * Copyright (c) 2015 the original author or authors
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
    public void shouldCreateCharHashMapTrie() {

        // when
        Trie<String> trie = Tries.newCharHashMapTrie();

        // then
        assertNotNull(trie);
    }

    @Test
    public void shouldCreateCharHashMapTrieWithInitialCapacity() {

        // when
        Trie<String> trie = Tries.newCharHashMapTrie(16);

        // then
        assertNotNull(trie);
    }

    @Test
    public void shouldCreateCharHashMapTrieWithInitialCapacityAndLoadFactor() {

        // when
        Trie<String> trie = Tries.newCharHashMapTrie(16, 0.75f);

        // then
        assertNotNull(trie);
    }
}