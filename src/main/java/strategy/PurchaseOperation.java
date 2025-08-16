package strategy;

import db.Storage;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity) {
        int currentQuantity = Storage.get(fruit);
        int newQuantity = currentQuantity - quantity;
        if (newQuantity < 0) {
            throw new RuntimeException("Not enough "
                    + fruit
                    + " in stock to complete purchase of "
                    + quantity);
        }
        Storage.set(fruit, newQuantity);
    }
}
