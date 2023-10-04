package core.basesyntax.service.parser.impl;

import core.basesyntax.service.parser.WriteParser;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvWriteParserImpl implements WriteParser {
    private static final String COMMA_SEPARATOR = ",";
    private static final String TYPE = "type";
    private static final String QUANTITY = "quantity";

    @Override
    public String parseProcessedData(Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder();
        builder.append(TYPE)
                .append(COMMA_SEPARATOR)
                .append(QUANTITY)
                .append(System.lineSeparator());
        String processedData = map.entrySet().stream()
                .map(entry -> entry.getKey() + COMMA_SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        return builder.append(processedData).toString();
    }
}
