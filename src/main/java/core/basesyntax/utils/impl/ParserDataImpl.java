package core.basesyntax.utils.impl;

import core.basesyntax.utils.ParserData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParserDataImpl implements ParserData {
    public Map<String, Integer> parsedWithFile(List<String> data) {
        return data.stream()
                .skip(1)
                .map(s -> s.replaceAll("\\s+", "").split(","))
                .collect(Collectors.toMap(s -> s[1], s -> Integer.parseInt(s[2])));
    }
}
