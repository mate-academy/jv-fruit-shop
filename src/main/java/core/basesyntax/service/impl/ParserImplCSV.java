package core.basesyntax.service.impl;

import core.basesyntax.Parser;

import java.util.List;
import java.util.stream.Collectors;

public class ParserImplCSV implements Parser {
    private static final String DEFAULT_DELIMITER = " ";
    private String delimiter;
    public ParserImplCSV() {
        this.delimiter = DEFAULT_DELIMITER;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public ParserImplCSV setDelimiter(String delimiter) {
        this.delimiter = delimiter;
        return this;
    }

    @Override
    public List<String[]> parse(List<String> stringList) {
        return stringList.stream()
                .map(s -> s.split(delimiter))
                .collect(Collectors.toList());
    }
}
