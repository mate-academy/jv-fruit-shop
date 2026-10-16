package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int currentAmount = Storage.fruitModels.getOrDefault(fruit, 0);

        if (currentAmount - quantity < 0) {
            throw new RuntimeException("Not enough stock for fruit: " + fruit
                    + ". Current balance: " + currentAmount + ", requested: " + quantity);
        }

        Storage.fruitModels.put(fruit, currentAmount - quantity);
    }
}
