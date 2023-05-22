package strategy;

import db.Storage;
import model.FruitTransaction;
import service.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        if (fruitName == null) {
            throw new RuntimeException("No such fruit found");
        }
        int purchasedQuantity = fruitTransaction.getQuantity();
        int oldQuantity = Storage.fruits.get(fruitName);
        if (purchasedQuantity - oldQuantity < 0) {
            throw new RuntimeException("Such a number of fruits not found");
        }
        Storage.fruits.put(fruitName, oldQuantity - purchasedQuantity);
    }
}
