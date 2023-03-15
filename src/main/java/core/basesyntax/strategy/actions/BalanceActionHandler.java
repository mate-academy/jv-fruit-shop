package core.basesyntax.strategy.actions;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class BalanceActionHandler implements ActionHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
