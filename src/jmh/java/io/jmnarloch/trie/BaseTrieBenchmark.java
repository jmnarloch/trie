package io.jmnarloch.trie;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 *
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public abstract class BaseTrieBenchmark {

    private static final int VALUES = 1024;

    private Trie<String> trie;
    private Set<String> values;
    private String key;

    @Setup
    public void before() {

        values = getValues();
        trie = createTrie();
        for(String value : values) {
            trie.put(value, value);
            key = value;
        }
    }


    @Benchmark
    public void benchmarkPut() {

        trie.put(key, key);
    }

    @Benchmark
    public void benchmarkGet() {

        trie.get(key);
    }

    @Benchmark
    public void benchmarkContains() {

        trie.containsKey(key);
    }

    @Benchmark
    public void benchmarkPrefix() {

        trie.prefix(key);
    }

    @Benchmark
    public void benchmarkPrefixKey() {

        trie.prefixKey(key);
    }

    @Benchmark
    public void benchmarkKeys() {

        trie.keySet();
    }

    protected Set<String> getValues() {

        Set<String> values = new HashSet<>();
        for(int ind = 0; ind < VALUES; ind++) {
            values.add(UUID.randomUUID().toString());
        }
        return values;
    }

    protected abstract Trie<String> createTrie();
}
