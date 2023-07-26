package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ListOfFruitTransactionFromString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfFruitTransactionFromStringImpl implements
        ListOfFruitTransactionFromString<FruitTransaction> {
    public static final String DELIMITER = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convert(String csvData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] lines = csvData.split("\\n");

        for (int i = 1; i < lines.length; i++) {
            FruitTransaction fruitTransaction = convertToTransaction(lines[i]);
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
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
