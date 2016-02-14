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

In effort to minimize the memory consumption we can design our tree as a 3-way with node links corresponding to character
being lower, equal or greater then given nodes character.

The available implementation:

* Tst

## TODO

* Compressed trie - Patricia trie
* Immutable trie

## License

Apache 2.0