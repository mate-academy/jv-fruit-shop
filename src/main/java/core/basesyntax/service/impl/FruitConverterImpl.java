package core.basesyntax.service.impl;

import static core.basesyntax.model.Operation.getAllAllowedOperationTypes;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitConverter;
import java.util.ArrayList;
import java.util.List;

public class FruitConverterImpl implements FruitConverter<FruitTransaction> {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int DIFFERENCE_BETWEEN_INDEX_AND_ROW_NUMBER = 2;
    private int currentLineInInputFile;

    @Override
    public List<FruitTransaction> convert(String string) {
        checkStringForNull(string);
        String[] rawTransactions = string.split(System.lineSeparator());
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 0; i < rawTransactions.length; i++) {
            String[] rawTransaction = rawTransactions[i].split(",");
            currentLineInInputFile = i + DIFFERENCE_BETWEEN_INDEX_AND_ROW_NUMBER;
            Operation operation =
                    defineOperationType(rawTransaction[OPERATION_INDEX]);
            int quantity = Integer.parseInt(rawTransaction[QUANTITY_INDEX]);
            checkQuantityForNegativeNumber(quantity);
            FruitTransaction newFruitTransaction = new FruitTransaction(operation,
                    rawTransaction[FRUIT_INDEX], quantity);
            transactions.add(newFruitTransaction);
        }
        return transactions;
    }

    private void checkStringForNull(String string) {
        if (string == null) {
            throw new RuntimeException("Input string is null");
        }
    }

    private void checkQuantityForNegativeNumber(int quantity) {
        if (quantity <= 0) {
            throw new RuntimeException("Invalid quantity on line " + currentLineInInputFile
                    + "! Quantity can't be below or equals zero! Actual number is " + quantity);
        }
    }

    private Operation defineOperationType(String type) {
        switch (type) {
            case "b":
                return Operation.BALANCE;
            case "p":
                return Operation.PURCHASE;
            case "r":
                return Operation.RETURN;
            case "s":
                return Operation.SUPPLY;
            default:
                throw new RuntimeException("Invalid transaction type on line "
                        + currentLineInInputFile + "! It's " + type + ", but allowed types are: "
                        + getAllAllowedOperationTypes());
        }
    }
}
