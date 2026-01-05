package core.basesyntax.strategy;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.Transaction;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void handle(Transaction transaction, Inventory inventory) {
        String fruit = transaction.getFruit();
        Integer quantity = transaction.getQuantity();
        inventory.setFruitQuantity(fruit, quantity);
    }
}
