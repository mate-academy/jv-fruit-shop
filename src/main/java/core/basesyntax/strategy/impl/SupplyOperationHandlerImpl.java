package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandlerImpl implements OperationHandler {

    @Override
    public void process(FruitTransaction transaction) {
        int oldQuantity = FruitStorage.fruitQuantities.get(transaction.getFruit());
        FruitStorage.fruitQuantities
                .put(transaction.getFruit(), oldQuantity + transaction.getQuantity());
    }
}
