package core.basesyntax.strategy.actions.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.strategy.actions.ActionWithFruits;

public class ActionWithFruitsSupply implements ActionWithFruits {
    @Override
    public void getAmountAfterAction(String name, int amount) {
        if (Storage.get(name) == null) {
            Storage.put(name, amount);
            return;
        }
        Storage.put(name, Storage.get(name) + amount);
    }
}
