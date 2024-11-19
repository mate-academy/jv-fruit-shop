package core.basesyntax.model;

import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParser {
    private static final int OPERATION = 0;
    private static final int Fruit = 1;
    private static final int QUANTITY = 2;

    public List<FruitTransaction> parseTransaction(String[] transactions) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        for (int i = 1; i < transactions.length; i++) {
            String transaction = transactions[i];
            String[] parts = transaction.split(",");

            Operation operation = Operation.getOperation(parts[OPERATION]);

            int quantity = Integer.parseInt(parts[QUANTITY]);

            FruitTransaction fruitTransaction = new FruitTransaction(operation,
                    parts[Fruit], quantity);

            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
