package io.jmnarloch.trie;

/**
 *
 */
public class KolobokeCharHashMapTrieBenchmark extends BaseTrieBenchmark {

    @Override
    protected Trie<String> createTrie() {
        return new KolobokeCharHashMapTrie<>();
    }
}
