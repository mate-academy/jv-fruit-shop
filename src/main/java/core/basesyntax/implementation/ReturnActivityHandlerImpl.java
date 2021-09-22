package core.basesyntax.implementation;

import core.basesyntax.Storage;
import core.basesyntax.service.ActivityHandler;

public class ReturnActivityHandlerImpl implements ActivityHandler {
    @Override
    public void activity(String fruitName, int amount) {
        if (Storage.fruitStorage.get(fruitName) == null) {
            throw new RuntimeException("Balance should be first activity");
        }
        Storage.fruitStorage.put(fruitName, Storage.fruitStorage.get(fruitName) + amount);
    }
}
