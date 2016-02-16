# Trie

> Trie tree implementation in Java

[![Build Status](https://travis-ci.org/jmnarloch/trie.svg?branch=master)](https://travis-ci.org/jmnarloch/trie)
[![Coverage Status](https://coveralls.io/repos/jmnarloch/trie/badge.svg?branch=master&service=github)](https://coveralls.io/github/jmnarloch/trie?branch=master)

## Setup

Add the module to your project:

```xml
<dependency>
  <groupId>io.jmnarloch</groupId>
  <artifactId>trie</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Features

### Trie

The Trie is a R way tree that is designed for efficient string searches.

At this moment this component defines four different implementation of the Trie, all of which differs slightly
in performance, but far most with the memory consumption.

The available Trie implementations are:

* ArrayTrie
* HashMapTrie
* TroveCharHashMapTrie - that uses Trove TCharObjectHashMap
* KolobokeCharHashMapTrie - that uses Koloboke HashCharObjMap

### Ternary Trie Tree

In effort to minimize the memory consumption we can design our tree as a 3-way tree with node links corresponding to character
being lower, equal or greater then given node character.

The available implementation:

* Tst

## Benchmark

Project includes simple JMH benchmark that measures the throughput of selected operations on the data structures.
For the sake of the benchmark every Trie instance has been populated with 1024 unique entries.
The benchmark measures the throughput of retrieving a key value and inserting a new one.

| Data structure          | put() (ops/sec) | get() (ops/sec) |
|-------------------------|-----------------|-----------------|
| Tst                     |   2299545,308   |   8842305,865   |
| ArrayTrie               |   3420565,537   |   6006965,043   |
| HashMapTrie             |   1934020,719   |   2256343,001   |
| TroveCharHashMapTrie    |   1455906,520   |   1823093,485   |
| KolobokeCharHashMapTrie |                 |                 |

* Benchmark run on Intel Core i7 2.2 GHz (4770HQ)

## Memory foot print

Tested on 64 bit JVM with enabled pointer compression (-XX:+UseCompressedOops - which is enabled by default for Java 8)

| Data structure             | Memory (bytes) |
|----------------------------|----------------|
| Tst                        |       56       |
| ArrayTrie - Unicode        |     262184     |
| ArrayTrie - Extended ASCII |     1064       |
| ArrayTrie - ASCII          |      552       |
| HashMapTrie                |       72*      |
| TroveCharHashMapTrie       |      320       |
| KolobokeCharHashMapTrie    |      376       |

Measured using [JAMM](https://github.com/jbellis/jamm). The memory sized includes the object overhead and padding.

* HashMapTrie - the size appears to be size of empty HashMap, but it expands when new entries are being added.

## TODO

* Compressed trie - Patricia trie
* Immutable trie

## License

Apache 2.0