package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParserService;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParserService implements TransactionParserService {
    private static final int HEADER_LINE = 0;
    private static final String SEPARATOR = ",";
    private static final int TRANSACTION_PARAMS_COUNT = 3;
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int FRUIT_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> lines) {
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
            if (parsedLine.length != TRANSACTION_PARAMS_COUNT) {
                throw new RuntimeException("Error parsing transactions. Invalid transaction: "
                        + line);
            }
            for (int i = 0; i < parsedLine.length; i++) {
                parsedLine[i] = parsedLine[i].strip().toLowerCase();
            }
            FruitTransaction transaction = new FruitTransaction();
            transaction.setOperation(parseOperation(parsedLine[OPERATION_TYPE]));
            if (parsedLine[FRUIT_NAME].isEmpty()) {
                throw new RuntimeException("Can't parse transactions. Name can't be empty: "
                        + line);
            }
            transaction.setFruit(parsedLine[FRUIT_NAME]);
            transaction.setQuantity(parseQuantity(parsedLine[FRUIT_QUANTITY]));
            transactions.add(transaction);
        }
        return transactions;
    }

    private FruitTransaction.Operation parseOperation(String operationType) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(operationType)) {
                return operation;
            }
        }
        throw new RuntimeException("Can't parse transactions. Unknown operation: '"
                + operationType + "'");
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
