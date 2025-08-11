package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";
    private static final int ARRAY_LENGTH = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> transactions) {
        return transactions.stream()
                .skip(1)
                .map(this::getFromCsv)
                .toList();
    }

    private FruitTransaction getFromCsv(String line) {

        String[] words = line.split(SEPARATOR);
        FruitTransaction.Operation operation =
                FruitTransaction.Operation.getOperation(words[OPERATION_INDEX]);
        if (words.length < ARRAY_LENGTH) {
            throw new IllegalArgumentException("invalid array length");
        }
        int quantity = Integer.parseInt(words[QUANTITY_INDEX]);
        if (quantity < 0) {
            throw new IllegalArgumentException(
                    "Quantity cannot be negative. Found: " + quantity + " in line: " + line);
        }
        return new FruitTransaction(operation, words[FRUIT_INDEX], quantity);
    }

    private FruitTransaction.Operation fromCode(String code) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new IllegalArgumentException("Unknown operation code: " + code);
    }
}
