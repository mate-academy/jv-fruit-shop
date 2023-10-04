package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void calculateValueByOperation(FruitTransaction model) {
        FruitStorage.fruitsStorage.put(model.getFruit(), model.getQuantity());
    }
}
