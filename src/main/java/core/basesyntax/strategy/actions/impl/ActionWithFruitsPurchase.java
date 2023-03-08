package core.basesyntax.strategy.actions.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.actions.ActionWithFruits;

public class ActionWithFruitsPurchase implements ActionWithFruits {
    @Override
    public void getAmountAfterAction(String name, int amount) {
        if (Storage.get(name) == null || Storage.get(name) <= 0
                || Storage.get(name) < amount) {
            throw new RuntimeException("Not enough fruits in storage");
        }
        Storage.put(name, Storage.get(name) - amount);
    }
}
