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
    public List<Transaction> parse(List<String> rawData) {
        if (rawData == null || rawData.isEmpty()) {
            throw new IllegalArgumentException("Invalid transaction line: " + rawData);
        }
        List<Transaction> transactions = new ArrayList<>();
        for (String line: rawData) {
            String[] parts = line.split(SEPARATOR);
            if (parts.length != EXPECTED_PARTS) {
                throw new IllegalArgumentException("Invalid transaction format: " + line);
            }
            Transaction.Operation operation = Transaction.Operation
                    .valueOf(parts[OPERATION_TYPE].trim().toUpperCase());
            Fruit fruit = new Fruit(parts[FRUIT_NAME].trim());
            int quantity = Integer.parseInt(parts[QUANTITY].trim());
            Transaction transaction = new Transaction(operation,fruit,quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
