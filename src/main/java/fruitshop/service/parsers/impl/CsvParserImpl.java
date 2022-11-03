package fruitshop.service.parsers.impl;

import fruitshop.service.parsers.CsvParser;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CsvParserImpl implements CsvParser {
    private static final Pattern REGEX_NEW_LINE = Pattern.compile(System.lineSeparator());
    private static final Pattern REGEX_ROW_DELIMITER = Pattern.compile(",");

    public List<List<String>> parse(String data) {
        return Arrays
                .stream(REGEX_NEW_LINE.split(data))
                .map(s -> Arrays.asList(REGEX_ROW_DELIMITER.split(s)))
                .collect(Collectors.toList());
    }
}
