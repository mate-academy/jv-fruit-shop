package core.basesyntax.strategy.activities;

import core.basesyntax.db.Storage;

public class BalanceHandler implements ActivitiesHandler{
    @Override
    public void act(String fruit, int quantity) {
        Storage.storage.put(fruit, quantity);
    }
}
