package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitTransactionParser implements TransactionParser {
    private static final int HEADER_LINE = 0;
    private static final String SEPARATOR = ",";
    private static final int TRANSACTION_PARAMS_COUNT = 3;
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseAll(List<String> lines) {
        if (lines.isEmpty()) {
            throw new RuntimeException("Can't parse transactions. Transaction list is empty!");
        }
        lines.remove(HEADER_LINE);
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            if (line.isBlank()) {
                continue;
            }
            String[] parsedLine = line.split(SEPARATOR);
            validate(parsedLine);
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(parseOperation(parsedLine[OPERATION_TYPE]));
            transaction.setFruit(parseFruitName(parsedLine[FRUIT_NAME]));
            transaction.setQuantity(parseQuantity(parsedLine[FRUIT_QUANTITY]));
            transactions.add(transaction);
        }
        return transactions;
    }

    private void validate(String[] parsedLine) {
        if (parsedLine.length != TRANSACTION_PARAMS_COUNT) {
            throw new RuntimeException("Error parsing transactions. Invalid transaction: "
                    + Arrays.toString(parsedLine));
        }
        for (int i = 0; i < parsedLine.length; i++) {
            parsedLine[i] = parsedLine[i].strip().toLowerCase();
        }
    }

    private FruitTransaction.Operation parseOperation(String operationType) {
        FruitTransaction.Operation operation = FruitTransaction.Operation
                .fromString(operationType);
        if (operation == null) {
            throw new RuntimeException("Can't parse transactions. Unknown operation: '"
                    + operationType + "'");
        }
        return operation;
    }

    private String parseFruitName(String fruitName) {
        if (fruitName.isBlank()) {
            throw new RuntimeException("Can't parse transactions. Name can't be empty!");
        }
        return fruitName;
    }

    private int parseQuantity(String quantity) {
        int result;
        try {
            result = Integer.parseInt(quantity);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error parsing transactions. Invalid quantity value '"
                    + quantity + "'", e);
        }
        if (result < 0) {
            throw new RuntimeException("Error parsing transactions. Quantity can't be negative: "
                    + quantity);
        }
        return result;
    }
}
