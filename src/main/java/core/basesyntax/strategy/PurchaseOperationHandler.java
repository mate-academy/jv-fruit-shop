package core.basesyntax.strategy;

import core.basesyntax.db.Inventory;
import core.basesyntax.model.Transaction;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void handle(Transaction transaction, Inventory inventory) {
        String fruit = transaction.getFruit();
        Integer quantity = transaction.getQuantity();
        Integer newQuantity = inventory.getFruitQuantity(fruit) - quantity;
        if (newQuantity < 0) {
            throw new RuntimeException("Quantity can`t be less than 0!");
        }
        inventory.setFruitQuantity(fruit, newQuantity);
    }
}
