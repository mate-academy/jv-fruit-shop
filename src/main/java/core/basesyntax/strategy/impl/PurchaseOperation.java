package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.StrategyOperation;

public class PurchaseOperation implements StrategyOperation {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Storage.decreaseFruitQuantity(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
