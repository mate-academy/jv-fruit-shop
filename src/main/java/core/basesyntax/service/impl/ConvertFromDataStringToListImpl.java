package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ConvertFromDataStringToList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertFromDataStringToListImpl implements
        ConvertFromDataStringToList<FruitTransaction> {
    public static final String DELIMITER = ",";
    public static final String NEW_LINE = "\\n";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convert(String csvData) {
        String[] lines = csvData.split(NEW_LINE);

        return Arrays.stream(lines)
                .skip(1)
                .map(this::convertToTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction convertToTransaction(String line) {
        String[] parts = line.split(DELIMITER);
        if (parts.length != 3) {
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
