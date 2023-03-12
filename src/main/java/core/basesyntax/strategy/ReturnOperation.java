package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements StrategyCalculator {
    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        Storage.STORAGE.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity()
                + Storage.STORAGE.get(fruitTransaction.getFruit()));
    }
}
