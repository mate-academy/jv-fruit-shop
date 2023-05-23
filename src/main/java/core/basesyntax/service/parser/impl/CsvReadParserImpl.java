package core.basesyntax.service.parser.impl;

import core.basesyntax.model.fruit.Operation;
import core.basesyntax.model.fruit.Record;
import core.basesyntax.service.parser.ReadParser;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReadParserImpl implements ReadParser {
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public List<Record> parseFileData(List<String> data) {
        data.remove(0);
        return data.stream()
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private Record getFromCsvRow(String row) {
        String[] fields = row.split(COMMA_SEPARATOR);
        Operation operation = Operation.getOperationFromString(fields[0]);
        String fruit = fields[1];
        int quantity = Integer.parseInt(fields[2]);
        return new Record(operation, fruit, quantity);
    }
}
