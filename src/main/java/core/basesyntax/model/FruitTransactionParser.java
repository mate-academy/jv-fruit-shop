package core.basesyntax.model;

import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int Fruit_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> parseTransaction(String[] transactions) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        for (int i = 1; i < transactions.length; i++) {
            String transaction = transactions[i];
            String[] parts = transaction.split(",");

            Operation operation = Operation.getOperation(parts[OPERATION_INDEX]);

            int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);

            FruitTransaction fruitTransaction = new FruitTransaction(operation,
                    parts[Fruit_INDEX], quantity);

            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
