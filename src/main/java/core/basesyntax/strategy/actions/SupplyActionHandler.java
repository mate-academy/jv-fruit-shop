package core.basesyntax.strategy.actions;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;

public class SupplyActionHandler implements ActionHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.plus(transaction.getFruit(), transaction.getQuantity());
    }
}
