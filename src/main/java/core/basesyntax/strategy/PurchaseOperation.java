package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements StrategyCalculator {
    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        Storage.STORAGE.put(fruitTransaction.getFruit(),
                Storage.STORAGE.get(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity());
    }
}
