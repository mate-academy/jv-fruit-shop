package core.basesyntax.service;

import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA_SEPARATOR = ",";
    private static final int EXPECTED_ARRAY_LENGTH = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final long SKIP_HEADER_COUNT = 1;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("Input lines list can not be null");
        }
        return lines.stream()
                .skip(SKIP_HEADER_COUNT)
                .filter(line -> line != null && !line.isBlank())
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String line) {
        String[] parsedData = line.split(COMMA_SEPARATOR);
        if (parsedData.length != EXPECTED_ARRAY_LENGTH) {
            throw new RuntimeException("Invalid csv line format " + line);
        }
        FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(
                parsedData[OPERATION_INDEX].trim());
        String fruit = parsedData[FRUIT_INDEX].trim();
        int quantity = Integer.parseInt(parsedData[QUANTITY_INDEX].trim());
        if (quantity < 0) {
            throw new RuntimeException("Quantity can not be negative: " + line);
        }
        return new FruitTransaction(operation, fruit, quantity);
    }
}
