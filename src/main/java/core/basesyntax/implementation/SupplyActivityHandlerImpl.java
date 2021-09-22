package core.basesyntax.implementation;

import core.basesyntax.Storage;
import core.basesyntax.activity.ActivityHandler;

public class SupplyActivityHandlerImpl implements ActivityHandler {
    @Override
    public void activity(String fruitName, int amount) {
        Storage.fruitStorage.put(fruitName, Storage.fruitStorage.get(fruitName) + amount);
    }
}
