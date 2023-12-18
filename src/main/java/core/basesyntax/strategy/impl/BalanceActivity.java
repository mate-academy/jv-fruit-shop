package core.basesyntax.strategy.impl;

import static core.basesyntax.db.Storage.storage;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.ActivityHandler;

public class BalanceActivity implements ActivityHandler {
    @Override
    public void updateBalance(FruitTransaction transaction) {
        if (!storage.containsKey(transaction.getFruit())) {
            storage.put(transaction.getFruit(), transaction.getQuantity());
        } else {
            if (storage.get(transaction.getFruit()) != transaction.getQuantity()) {
                throw new RuntimeException("Not equals value for fruits: "
                        + transaction.getFruit()
                        + ", must be " + storage.get(transaction.getFruit())
                        + " after previous session, "
                        + "but you try to update database invalid value like:"
                        + transaction.getQuantity());
            }
        }
    }
}
