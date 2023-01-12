package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        Storage.FRUITS_MAP.compute(fruitTransaction.getFruit(),
                (k, v) -> v + fruitTransaction.getQuantity());
    }
}
