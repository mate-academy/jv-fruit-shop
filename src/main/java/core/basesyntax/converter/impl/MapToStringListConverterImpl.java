package core.basesyntax.converter.impl;

import core.basesyntax.converter.MapToStringListConverter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToStringListConverterImpl implements MapToStringListConverter {
    @Override
    public List<String> parseMap(Map<String, Integer> map) {
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
    }
}
