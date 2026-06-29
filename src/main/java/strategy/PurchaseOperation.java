package strategy;

import db.Storage;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int currentQuantity = Storage.getQuantity(fruit);
        int newQuantity = currentQuantity - transaction.getQuantity();

        if (newQuantity < 0) {
            throw new RuntimeException("Not enough fruits in storage for purchase: " + fruit
                    + ". Available: " + currentQuantity
                    + ", requested: " + transaction.getQuantity());
        }
        Storage.updateQuantity(fruit, newQuantity);
    }
}



