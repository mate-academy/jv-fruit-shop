package core.basesyntax.implementation;

import core.basesyntax.Storage;
import core.basesyntax.activity.ActivityHandler;

public class PurchaseActivityHandlerImpl implements ActivityHandler {
    @Override
    public void activity(String fruitName, int amount) {
        if (Storage.fruitStorage.get(fruitName) == null) {
            throw new RuntimeException("Balance should be first activity");
        }
        if (Storage.fruitStorage.get(fruitName) < 2) {
            throw new RuntimeException("You couldn't sale more than you had");
        }
        Storage.fruitStorage.put(fruitName, Storage.fruitStorage.get(fruitName) - amount);
    }
}
