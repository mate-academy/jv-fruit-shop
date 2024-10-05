package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import java.util.ArrayList;
import java.util.List;

public class TransactionParser {
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] data = line.split(",");
            OperationType operation = OperationType.fromCode(data[0]);
            String fruit = data[1];
            int quantity = Integer.parseInt(data[2]);

            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
