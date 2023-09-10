package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void execute(String fruitName, int quantity) {
        if (Storage.storage.get(fruitName) - quantity < 0) {
            throw new RuntimeException("There is no enough " + fruitName + " in storage");
        } else {
            Storage.storage.put(fruitName, Storage.storage.get(fruitName) - quantity);
        }
    }
}
