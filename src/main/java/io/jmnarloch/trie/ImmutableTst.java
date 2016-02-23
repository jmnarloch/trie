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

import java.util.Map;

/**
 * An immutable implementation of Ternary Trie Tree. Once this data structure has been initialized,
 * there won't be possibility to modify it.
 *
 * @author Jakub Narloch
 */
public class ImmutableTst<T> extends AbstractTst<T> {

    /**
     * Creates new instance of {@link ImmutableTst} class.
     *
     * @param map the entries map
     * @throws IllegalArgumentException if map is {@code null}
     */
    public ImmutableTst(Map<String, T> map) {
        if(map == null) {
            throw new IllegalArgumentException("Parameter 'map' can not be null.");
        }
        for (Map.Entry<String, ? extends T> entry : map.entrySet()) {
            super.put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T put(String key, T value) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void putAll(Map<String, ? extends T> map) {
        throw new UnsupportedOperationException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T remove(String key) {
        throw new UnsupportedOperationException();
    }
}
