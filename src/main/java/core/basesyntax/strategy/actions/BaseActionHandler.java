package core.basesyntax.strategy.actions;

import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.storage.Storage;

public class BaseActionHandler implements ActionHandler {
    @Override
    public void apply(Storage storage, String fruit, Integer quantity) {
        storage.put(fruit, quantity);
    }

    @Override
    public boolean isApplicable(FruitTransaction.Operation action) {
        return FruitTransaction.Operation.BALANCE == action;
    }
}
