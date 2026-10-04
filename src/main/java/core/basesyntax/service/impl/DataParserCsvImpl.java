package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserCsvImpl implements DataParser {
    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .filter(line -> !line.isBlank())
                .map(this::getFromCsv)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromCsv(String line) {
        String[] fields = line.split(CSV_SEPARATOR);
        if (fields.length != 3) {
            throw new RuntimeException("Invalid CSV line format. Expected 3 fields");
        }
        FruitTransaction.Operation operation =
                FruitTransaction.Operation.fromCode(fields[OPERATION_INDEX]);
        int parsedQuantity = Integer.parseInt(fields[QUANTITY_INDEX]);
        if (parsedQuantity < 0) {
            throw new RuntimeException("Quantity don't can be negative");
        }
        return new FruitTransaction()
                .setOperation(operation)
                .setFruit(fields[FRUIT_INDEX])
                .setQuantity(parsedQuantity);
    }
}
