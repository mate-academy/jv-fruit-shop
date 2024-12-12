package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseOperation implements OperationHandler {
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        int currentBalance = Storage.getAll().get(transaction.getFruit());

        if (currentBalance - quantity < 0) {
            throw new RuntimeException("Insufficient quantity of fruit: " + fruit
                    + ". Current balance: " + currentBalance);
        }

        Storage.subtract(fruit, quantity);
    }
}
