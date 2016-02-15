package io.jmnarloch.trie;

/**
 *
 */
public class HashMapTrieBenchmark extends BaseTrieBenchmark {

    @Override
    protected Trie<String> createTrie() {
        return new HashMapTrie<>();
    }
}
