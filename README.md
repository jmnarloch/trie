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
* ImmutableTst

## Benchmark

Project includes simple JMH benchmark that measures the throughput of selected operations on the data structures.
For the sake of the benchmark every Trie instance has been populated with 1024 unique entries.
The benchmark measures the throughput of retrieving a key value and inserting a new one.

| Data structure          | put() (ops/sec) | get() (ops/sec) |
|-------------------------|-----------------|-----------------|
| Tst                     |   2299545,308   |  10051031,796   |
| ArrayTrie               |   3420565,537   |   6006965,043   |
| HashMapTrie             |   1934020,719   |   2256343,001   |
| TroveCharHashMapTrie    |   1455906,520   |   1823093,485   |
| KolobokeCharHashMapTrie |   1824541,577   |   3263378,461   |

* Benchmark run on Intel Core i7 2.2 GHz (4770HQ)

## Memory footprint

Tested on 64 bit JVM with enabled pointer compression (-XX:+UseCompressedOops - which is enabled by default for Java 8)
Measured using [JAMM](https://github.com/jbellis/jamm). The memory size includes the object overhead and padding.

### Size of single tree node

| Data structure             | Memory (bytes) |
|----------------------------|----------------|
| Tst                        |       56       |
| ArrayTrie - Unicode        |     262184     |
| ArrayTrie - Extended ASCII |     1064       |
| ArrayTrie - ASCII          |      552       |
| HashMapTrie                |       72*      |
| TroveCharHashMapTrie       |      320       |
| KolobokeCharHashMapTrie    |      376       |

* HashMapTrie - the size appears to be size of empty HashMap, but it expands when new entries are being added.

After populating the Trie trees with 1024 random 36 character length strings we may expect fallowing results:

| Data structure             | Memory (bytes) |
|----------------------------|----------------|
| Tst                        |     1553584    |
| ArrayTrie - Unicode        |        -       |
| ArrayTrie - Extended ASCII |    37300464    |
| ArrayTrie - ASCII          |    19406576    |
| HashMapTrie                |     6464752    |
| TroveCharHashMapTrie       |    11301264    |
| KolobokeCharHashMapTrie    |     6826752    |

## TODO

* Compressed trie - Patricia trie

## License

Apache 2.0