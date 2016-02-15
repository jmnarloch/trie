package io.jmnarloch.trie;

/**
 *
 */
public class TstBenchmark extends BaseTrieBenchmark {

    @Override
    protected Trie<String> createTrie() {
        return new Tst<>();
    }
}
