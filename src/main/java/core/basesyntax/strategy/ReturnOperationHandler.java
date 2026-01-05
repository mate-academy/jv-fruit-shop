package core.basesyntax.strategy;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.Transaction;

public class ReturnOperationHandler implements OperationHandler {

    @Override
    public void handle(Transaction transaction, Inventory inventory) {
        String fruit = transaction.getFruit();
        Integer quantity = transaction.getQuantity();
        Integer newQuantity = inventory.getFruitQuantity(fruit) + quantity;
        inventory.setFruitQuantity(fruit, newQuantity);
    }
}
