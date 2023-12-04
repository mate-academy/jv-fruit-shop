package core.basesyntax.strategy.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer valueBeforeSupply = FruitStorage.FRUITS.get(fruitTransaction.getFruit());
        Integer valueAfterSupply = valueBeforeSupply + fruitTransaction.getQuantity();
        FruitStorage.FRUITS.put(fruitTransaction.getFruit(), valueAfterSupply);
    }
}
