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

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * A implementation of Ternary Trie Tree.
 *
 * @author Jakub Narloch
 */
public class Tst<T> implements Trie<T> {

    private TstNode root;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return root != null ? root.size : 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T put(String key, T value) {
        notEmpty(key, "Key must be not null or not empty string.");

        return put(root, key, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void putAll(Map<String, ? extends T> map) {
        notNull(map, "Map can not be null");

        for (Map.Entry<String, ? extends T> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsKey(String key) {
        notEmpty(key, "Key must be not null or not empty string.");

        return get(key) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T get(String key) {
        notEmpty(key, "Key must be not null or not empty string.");

        return get(root, key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T prefix(String key) {
        notEmpty(key, "Key must be not null or not empty string.");

        return prefix(root, key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String prefixKey(String key) {
        notEmpty(key, "Key must be not null or not empty string.");

        return prefixKey(root, key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(String key) {
        notEmpty(key, "Key must be not null or not empty string.");

        return remove(root, key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<String> keySet() {
        final HashSet<String> keys = new HashSet<>();
        keys(root, keys);
        return keys;
    }

    private T put(TstNode root, String key, T value) {

        int index = 0;
        char prevC = 0;

        TstNode node = root, prev = null;
        final Deque<TstNode> stack = new LinkedList<>();

        while (index < key.length()) {
            final char c = getChar(key, index);
            if (node == null) {
                node = new TstNode();
                node.c = c;
                if (prev == null) {
                    this.root = node;
                } else {
                    if (prevC < prev.c) {
                        prev.left = node;
                    } else if (prevC > prev.c) {
                        prev.right = node;
                    } else {
                        prev.mid = node;
                    }
                }
            }
            if (c == node.c) {
                index++;
            }
            prev = node;
            prevC = c;
            stack.push(node);
            node = moveNext(node, c);
        }

        if (node != null) {
            T oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        node = new TstNode();
        node.value = value;
        node.size = 1;
        prev.mid = node;

        while (!stack.isEmpty()) {
            node = stack.pop();
            node.size += 1;
        }
        return null;
    }

    private T get(TstNode node, String key) {

        int index = 0;
        while (node != null) {
            if (index == key.length()) {
                return node.value;
            }
            final char c = getChar(key, index);
            if (c == node.c) {
                index++;
            }
            node = moveNext(node, c);

        }
        return null;
    }

    private T prefix(TstNode node, String key) {

        int index = 0;
        T value = null;
        while (node != null) {
            if (index == key.length()) {
                if (node.value != null) {
                    value = node.value;
                }
                break;
            }
            final char c = getChar(key, index);
            if (c == node.c) {
                if (node.value != null) {
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

        while (node != null) {
            if (index == key.length()) {
                if (node.value != null) {
                    longestPrefix = index;
                }
                break;
            }
            final char c = getChar(key, index);
            if (c == node.c) {
                path.append(c);
                index++;
                if (node.value != null) {
                    longestPrefix = index;
                }
            }
            node = moveNext(node, c);
        }
        if (longestPrefix == -1) {
            return null;
        }
        return path.substring(0, longestPrefix);
    }

    private T remove(TstNode node, String key) {

        int index = 0;

        final Deque<TstNode> stack = new LinkedList<>();

        while (node != null) {
            if (index == key.length()) {
                break;
            }
            final char c = getChar(key, index);
            if (c == node.c) {
                index++;
            }
            stack.push(node);
            node = moveNext(node, c);
        }

        if (index < key.length() || node == null || node.value == null) {
            return null;
        }
        final T value = node.value;
        node.value = null;
        node.size -= 1;

        TstNode prev = node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            node.size -= 1;

            if (prev.size == 0) {
                if (node.left == prev) {
                    node.left = null;
                } else if (node.right == prev) {
                    node.right = null;
                } else {
                    node.mid = null;
                }
            }
            prev = node;
        }
        if (isEmpty()) {
            root = null;
        }
        return value;
    }

    private void keys(TstNode root, HashSet<String> keys) {

        final StringBuilder path = new StringBuilder();
        final Deque<TraversedPath> stack = new LinkedList<>();
        stack.push(new TraversedPath(TraversedPathAction.VISIT, -1, root));

        while (!stack.isEmpty()) {
            final TraversedPath traversedPath = stack.pop();
            if (traversedPath.action == TraversedPathAction.BACKUP) {
                path.deleteCharAt(path.length() - 1);
                continue;
            }
            if (traversedPath.c != -1) {
                path.append((char) traversedPath.c);
            }
            final TstNode node = traversedPath.node;
            if (node.value != null) {
                keys.add(path.toString());
            }
            if (node.right != null) {
                stack.push(new TraversedPath(TraversedPathAction.VISIT, -1, node.right));
            }
            if (node.mid != null) {
                stack.push(new TraversedPath(TraversedPathAction.BACKUP, -1, null));
                stack.push(new TraversedPath(TraversedPathAction.VISIT, node.c, node.mid));
            }
            if (node.left != null) {
                stack.push(new TraversedPath(TraversedPathAction.VISIT, -1, node.left));
            }
        }
    }

    private TstNode moveNext(TstNode node, char c) {
        if (c < node.c) {
            node = node.left;
        } else if (c > node.c) {
            node = node.right;
        } else {
            node = node.mid;
        }
        return node;
    }

    private char getChar(String key, int index) {
        return key.charAt(index);
    }

    private void notNull(Object value, String message) {
        if (value == null) {
            throw new IllegalArgumentException(message);
        }
    }

    private void notEmpty(String value, String message) {
        notNull(value, message);
        if (value.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    private enum TraversedPathAction {
        VISIT, BACKUP
    }

    private final class TraversedPath {

        private final TraversedPathAction action;
        private final TstNode node;
        private final int c;

        public TraversedPath(TraversedPathAction action, int c, TstNode node) {
            this.action = action;
            this.c = c;
            this.node = node;
        }
    }

    private final class TstNode {

        private char c;

        private T value;

        private int size;

        private TstNode left;
        private TstNode right;
        private TstNode mid;
    }
}
