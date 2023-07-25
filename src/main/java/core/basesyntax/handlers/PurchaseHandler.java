package core.basesyntax.handlers;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void operation(String fruit, int quantity) {
        int newQuantity = Storage.storage.get(fruit) - quantity;
        if (newQuantity < 0) {
            throw new RuntimeException("The quantity of fruits can't be less than 0");
        }
        Storage.storage.put(fruit, newQuantity);
    }
}
