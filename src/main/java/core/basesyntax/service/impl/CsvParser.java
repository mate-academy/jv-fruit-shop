package core.basesyntax.service.impl;

import core.basesyntax.service.Parser;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParser implements Parser {
    private static final String SPLIT_VALUE = ",";
    private static final int SKIP_HEADER_LINE_NUMBER = 1;

    @Override
    public List<String[]> parseData(List<String> rawData) {
        return rawData.stream()
                .skip(SKIP_HEADER_LINE_NUMBER)
                .map(string -> string.split(SPLIT_VALUE))
                .collect(Collectors.toList());
    }
}
