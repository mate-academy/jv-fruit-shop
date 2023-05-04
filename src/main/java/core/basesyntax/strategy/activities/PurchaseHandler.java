package core.basesyntax.strategy.activities;

import core.basesyntax.db.Storage;

public class PurchaseHandler implements ActivitiesHandler{
    @Override
    public void act(String fruit, int quantity) {
        int oldValue = Storage.storage.get(fruit);
        Storage.storage.put(fruit, oldValue - quantity);
    }
}
