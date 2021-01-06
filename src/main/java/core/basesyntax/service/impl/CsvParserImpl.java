package core.basesyntax.service.impl;

import core.basesyntax.service.CsvParser;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParserImpl implements CsvParser {
    @Override
    public List<String[]> parse(List<String> input) {
        return input.stream()
                .map(l -> l.split(","))
                .collect(Collectors.toList());
    }
}
