package io.jmnarloch.trie;

/**
 *
 */
public class TroveCharHashMapBenchmark extends BaseTrieBenchmark {

    @Override
    protected Trie<String> createTrie() {
        return new TroveCharHashMapTrie<>();
    }
}
