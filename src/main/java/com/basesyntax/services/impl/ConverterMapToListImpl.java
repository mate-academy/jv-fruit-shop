package com.basesyntax.services.impl;

import com.basesyntax.model.Fruit;
import com.basesyntax.services.ConverterMapToList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConverterMapToListImpl implements ConverterMapToList {
    private static final String COMMA = ",";

    @Override
    public List<String> convert(Map<Fruit, Integer> storage) {
        return storage.entrySet()
                .stream()
                .map(m -> m.getKey() + COMMA + m.getValue().toString())
                .collect(Collectors.toList());
    }

}
