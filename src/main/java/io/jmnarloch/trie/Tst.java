package io.jmnarloch.trie;

import java.util.Map;
import java.util.Set;

/**
 *
 */
public class Tst<T> implements Trie<T> {

    private TstNode root;

    private int size;

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T put(String key, T value) {
        return put(root, key, value);
    }

    @Override
    public void putAll(Map<String, ? extends T> map) {

        for(Map.Entry<String, ? extends T> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean containsKey(String key) {
        return get(key) != null;
    }

    @Override
    public T get(String key) {
        return get(root, key);
    }

    @Override
    public T prefix(String key) {
        return prefix(root, key);
    }

    @Override
    public String prefixKey(String key) {
        return prefixKey(root, key);
    }

    @Override
    public T remove(String key) {
        return null;
    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    private T put(TstNode root, String key, T value) {

        int index = 0;
        char prevC = 0;

        TstNode node = root, prev = null;

        while(index < key.length()) {
            final char c = getChar(key, index);
            if(node == null) {
                node = new TstNode();
                node.c = c;
                if(prev == null) {
                    this.root = node;
                } else {
                    if(prevC < prev.c) {
                        prev.left = node;
                    } else if(prevC > prev.c) {
                        prev.right = node;
                    } else {
                        prev.mid = node;
                    }
                }
                index++;
            } else {
                node = moveNext(node, c);
            }
            prevC = c;
            prev = node;
        }

        if(node != null) {
            T oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        node = new TstNode();
        node.value = value;
        return null;
    }

    private T get(TstNode node, String key) {

        int index = 0;
        while(node != null) {
            if(index == key.length()) {
                return node.value;
            }
            final char c =  getChar(key, index);
            if(c == node.c) {
                index++;
            }
            node = moveNext(node, c);

        }
        return null;
    }

    private T prefix(TstNode node, String key) {

        int index = 0;
        T value = null;
        while(node != null) {
            if(index == key.length()) {
                break;
            }
            final char c =  getChar(key, index);
            if(c == node.c) {
                if(node.value != null) {
                    value = node.value;
                }
                index++;
            }
            node = moveNext(node, c);
        }
        return value;
    }

    private String prefixKey(TstNode node, String key) {

        final StringBuilder path = new StringBuilder();
        int index = 0;
        int longestPrefix = -1;

        while(node != null) {
            if(index == key.length()) {
                break;
            }
            final char c = getChar(key, index);
            if(c == node.c) {
                path.append(c);
                index++;
                if(node.value != null) {
                    longestPrefix = index;
                }
            }
        }

        if(longestPrefix == -1) {
            return null;
        }
        return path.substring(0, longestPrefix);
    }

    private TstNode moveNext(TstNode node, char c) {
        if(c < node.c) {
            node = node.left;
        } else if(c > node.c) {
            node = node.right;
        } else {
            node = node.mid;
        }
        return node;
    }

    private char getChar(String key, int index) {
        return key.charAt(index);
    }

    private final class TstNode {

        private char c;

        private T value;

        private TstNode left;
        private TstNode right;
        private TstNode mid;
    }
}
