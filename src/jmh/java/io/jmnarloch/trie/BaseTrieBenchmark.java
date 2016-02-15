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
 * The base benchmark class for the {@link Trie}.
 *
 * @author Jakub Narloch
 */
@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.SECONDS)
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
    public String benchmarkPut() {

        return trie.put(key, key);
    }

    @Benchmark
    public String benchmarkGet() {

        return trie.get(key);
    }

    @Benchmark
    public boolean benchmarkContains() {

        return trie.containsKey(key);
    }

    @Benchmark
    public String benchmarkPrefix() {

        return trie.prefix(key);
    }

    @Benchmark
    public String benchmarkPrefixKey() {

        return trie.prefixKey(key);
    }

    @Benchmark
    public Set<String> benchmarkKeys() {

        return trie.keySet();
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
