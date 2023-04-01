package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int calculateValueByOperation(FruitTransaction model) {
        FruitStorage.fruitsStorage.put(model.getFruit(),
                FruitStorage.fruitsStorage.get(model.getFruit()) + model.getQuantity());
        return FruitStorage.fruitsStorage.get(model.getFruit());
    }
}
