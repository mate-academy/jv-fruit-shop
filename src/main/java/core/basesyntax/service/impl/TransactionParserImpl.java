package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
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
            parts = line.split(",");
            if (parts.length != 3) {
                throw new RuntimeException("Transactions parsing failed: "
                        + "wrong format in line: " + line);
            }
            try {
                operation = Operation.valueOf(parts[0]);
                fruitName = parts[1];
                quantity = Integer.parseInt(parts[2]);
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
