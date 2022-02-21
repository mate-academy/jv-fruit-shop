package core.basesyntax.dao;

import core.basesyntax.db.Storage;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(String fruit, int quantity) {
        if (!Storage.fruitStorage.containsKey(fruit)) {
            throw new RuntimeException("There are no " + fruit + " in storage now.");
        }
        int currentQuantity = Storage.fruitStorage.get(fruit);
        if (currentQuantity < quantity) {
            throw new RuntimeException("You can't buy "
                    + quantity + " "
                    + fruit
                    + " because there are only "
                    + currentQuantity
                    + " in the storage");
        }
        int newQuantity = currentQuantity - quantity;
        Storage.fruitStorage.put(fruit, newQuantity);
    }
}
