package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        Integer current = Storage.get(fruit);
        if (current == null) {
            throw new RuntimeException("Can't buy " + fruit + ": no such fruit in storage");
        }

        if (current < quantity) {
            throw new RuntimeException("Not enough " + fruit + " in storage. Available: "
                    + current + ", requested: " + quantity);
        }

        int newQuantity = current - quantity;
        Storage.put(fruit, newQuantity);
    }
}
