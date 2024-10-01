package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String SEPARATOR = ",";
    private static final int EXPECTED_PARTS = 3;
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<Transaction> parse(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();
        for (String line: lines) {
            String[] parts = line.split(SEPARATOR);
            if (parts.length != EXPECTED_PARTS) {
                throw new IllegalArgumentException("Invalid transaction format. "
                        + "Each line should contain exactly 3 parts separated by commas: "
                        + "operation, fruit name, and quantity." + line);
            }
            String type = parts[OPERATION_TYPE].trim();
            String fruitName = parts[FRUIT_NAME].trim();
            int quantity;
            try {
                quantity = Integer.parseInt(parts[QUANTITY].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Unable to parse quantity: "
                        + parts[QUANTITY]);
            }
            try {
                Transaction.Operation operation = Transaction.Operation.fromCode(type);
                Fruit fruit = new Fruit(fruitName);
                transactions.add(new Transaction(operation, fruit, quantity));
            } catch (IllegalArgumentException e) {
                System.out.println(("Invalid operation in line: " + line));
            }
        }
        return transactions;
    }
}
