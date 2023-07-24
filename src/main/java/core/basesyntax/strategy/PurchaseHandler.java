package core.basesyntax.strategy;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements OperationHandler {

    @Override
    public void execute(String fruitName, int quantity) {
        boolean isEnoughFruitsInStorage = Storage.storage.get(fruitName) - quantity >= 0;
        if (isEnoughFruitsInStorage) {
            Storage.storage.put(fruitName, Storage.storage.get(fruitName) - quantity);
        } else {
            throw new RuntimeException("There is no enough " + fruitName + " in storage");
        }
    }
}
