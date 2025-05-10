package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_POS = 0;
    private static final int FRUIT_NAME_POS = 1;
    private static final int QUANTITY_POS = 2;

    @Override
    public List<FruitTransaction> parse(List<String> transactionStrings) {
        if (transactionStrings == null || transactionStrings.isEmpty()) {
            throw new RuntimeException("Transactions parsing failed: "
                    + "no transactions found");
        }
        List<FruitTransaction> transactions = new ArrayList<>();
        String[] parts;
        Operation operation;
        String fruitName;
        int quantity;
        for (String line : transactionStrings) {
            parts = line.split(SEPARATOR);
            if (parts.length != 3) {
                throw new RuntimeException("Transactions parsing failed: "
                        + "wrong format in line: " + line);
            }
            try {
                operation = Operation.valueOf(parts[OPERATION_POS]);
                fruitName = parts[FRUIT_NAME_POS];
                quantity = Integer.parseInt(parts[QUANTITY_POS]);
                transactions.add(new FruitTransaction(operation, fruitName, quantity));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity format: " + parts[2], e);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Transactions parsing failed: "
                        + "invalid operation code: " + parts[0], e);
            }
        }
        return transactions;
    }
}
