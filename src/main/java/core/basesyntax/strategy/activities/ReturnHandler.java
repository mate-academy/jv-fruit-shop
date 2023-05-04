package core.basesyntax.strategy.activities;

import core.basesyntax.db.Storage;

public class ReturnHandler implements ActivitiesHandler{
    @Override
    public void act(String fruit, int quantity) {
        int oldValue = Storage.storage.get(fruit);
        Storage.storage.put(fruit, oldValue + quantity);
    }
}
