package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandler;

public class BalanceFruitHandlerImpl implements FruitHandler {
    @Override
    public void getActivity(FruitTransaction fruitTransaction) {
        Storage.getFruitsComposition().put(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
    }
}
