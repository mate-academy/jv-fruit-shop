package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.StringToListService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToFruitTransactionListService implements StringToListService<FruitTransaction> {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int DIFFERENCE_BETWEEN_INDEX_AND_ROW_NUMBER = 2;

    @Override
    public List<FruitTransaction> convert(String string) {
        checkStringForNull(string);
        String[] transactions = string.split(System.lineSeparator());
        List<FruitTransaction> parsedTransactions = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            String[] transactionInArray = transactions[i].split(",");
            int currentLineInInputFile = i + DIFFERENCE_BETWEEN_INDEX_AND_ROW_NUMBER;
            FruitTransaction.Operation operation =
                    defineOperationType(transactionInArray[OPERATION_INDEX],
                            currentLineInInputFile);
            int quantity = Integer.parseInt(transactionInArray[QUANTITY_INDEX]);
            checkQuantityForNegativeNumber(quantity, currentLineInInputFile);
            parsedTransactions
                    .add(new FruitTransaction(operation, transactionInArray[FRUIT_INDEX],quantity));
        }
        return parsedTransactions;
    }

    private void checkStringForNull(String string) {
        if (string == null) {
            throw new RuntimeException("Input string is null((");
        }
    }

    private void checkQuantityForNegativeNumber(int quantity, int currentLineInInputFile) {
        if (quantity < 0) {
            throw new RuntimeException("Invalid quantity on line " + currentLineInInputFile + "! Quantity "
                    + "can't be below zero! Actual number is " + quantity);
        }
    }

    private FruitTransaction.Operation defineOperationType(String type, int currentLineInInputFile) {
        switch (type) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "r":
                return FruitTransaction.Operation.RETURN;
            case "s":
                return FruitTransaction.Operation.SUPPLY;
            default:
                throw new RuntimeException("Invalid transaction type on line "
                        + currentLineInInputFile + "! It's " + type + ", but allowed types are: "
                        + getAllAllowedOperationTypes());
        }
    }

    private String getAllAllowedOperationTypes() {
        return Arrays.stream(FruitTransaction.Operation.values())
                .map(FruitTransaction.Operation::getCode)
                .collect(Collectors.joining(", "));
    }
}
