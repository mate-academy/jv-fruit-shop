package strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void processOperation(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = Storage.fruits.get(fruit);
        int quantityToBuy = fruitTransaction.getQuantity();
        if (quantity < quantityToBuy) {
            throw new RuntimeException("Unable to do operation(not enough fruits)");
        }
        Storage.fruits.put(fruit, quantity - quantityToBuy);
    }
}
