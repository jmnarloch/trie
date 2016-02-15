package io.jmnarloch.trie;

/**
 *
 */
public class ArrayTrieBenchmark extends BaseTrieBenchmark {

    @Override
    protected Trie<String> createTrie() {
        return new ArrayTrie<>(256);
    }
}
