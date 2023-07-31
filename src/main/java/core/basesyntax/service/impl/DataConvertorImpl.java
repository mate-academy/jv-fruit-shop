package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConvertor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataConvertorImpl implements
        DataConvertor<FruitTransaction> {
    private static final String DELIMITER = ",";
    private static final String NEW_LINE = "\\n";
    private static final int INDEX_OF_FIRST_LINE = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int MAX_NUMBER_OF_PARTS = 3;

    @Override
    public List<FruitTransaction> convert(String csvData) {
        String[] lines = csvData.split(NEW_LINE);

        return Arrays.stream(lines)
                .skip(INDEX_OF_FIRST_LINE)
                .map(this::convertToTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction convertToTransaction(String line) {
        String[] parts = line.split(DELIMITER);
        if (parts.length != MAX_NUMBER_OF_PARTS) {
            throw new IllegalArgumentException("Invalid CSV line: " + line);
        }

        String operationCode = parts[OPERATION_INDEX].trim();
        String fruit = parts[FRUIT_INDEX].trim();
        int quantity = Integer.parseInt(parts[QUANTITY_INDEX].trim());

        Operation operation = getOperationFromCode(operationCode);
        return new FruitTransaction(operation, fruit, quantity);
    }

    private Operation getOperationFromCode(String operationCode) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.getCode().equals(operationCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown operation code: "
                        + operationCode));
    }
}
