package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationStrategy implements OperationStrategy {
    @Override
    public void applyStrategy(String[] transaction) {
        if (transaction.length != 3) {
            throw new IllegalArgumentException("Invalid supply transaction format.");
        }
        String fruitName = transaction[1];
        int quantity = Integer.parseInt(transaction[2]);
        Storage storage = Storage.getInstance();
        storage.updateFruitQuantity(FruitTransaction.Operation.SUPPLY, fruitName, quantity);
    }
}
