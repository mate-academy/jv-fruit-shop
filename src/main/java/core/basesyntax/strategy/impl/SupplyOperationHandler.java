package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer valueBeforeSupply = Storage.FRUITS.get(fruitTransaction.getFruit());
        Integer valueAfterSupply = valueBeforeSupply + fruitTransaction.getQuantity();
        Storage.FRUITS.put(fruitTransaction.getFruit(), valueAfterSupply);
    }
}
