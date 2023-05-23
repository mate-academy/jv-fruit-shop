package core.basesyntax.service.impl;

import core.basesyntax.model.fruit.Operation;
import core.basesyntax.model.fruit.Record;
import core.basesyntax.service.Parser;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CsvParser implements Parser {
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public List<Record> parseFileData(List<String> data) {
        data.remove(0);
        return data.stream()
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    @Override
    public String parseProcessedData(Map<String, Integer> map) {
        StringBuilder builder = new StringBuilder();
        builder.append("type")
                .append(COMMA_SEPARATOR)
                .append("quantity")
                .append(System.lineSeparator());
        String processedData = map.entrySet().stream()
                .map(entry -> entry.getKey() + COMMA_SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        return builder.append(processedData).toString();
    }

    private Record getFromCsvRow(String row) {
        String[] fields = row.split(COMMA_SEPARATOR);
        Operation givenOperation = Operation.getOperationFromString(fields[0]);
        String fruit = fields[1];
        int quantity = Integer.parseInt(fields[2]);
        return new Record(givenOperation, fruit, quantity);
    }
}
