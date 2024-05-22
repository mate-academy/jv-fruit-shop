package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    @Override
    public List<FruitTransaction> parse(List<String> transactionStrings) {
        List<FruitTransaction> transactions = new ArrayList<>();
        String[] parts;
        for (String line : transactionStrings) {
            parts = line.split(",");
            FruitTransaction.Operation operation = FruitTransaction.Operation.valueOf(parts[0]);
            String fruitName = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            transactions.add(new FruitTransaction(operation, fruitName, quantity));
        }
        return transactions;
    }
}
