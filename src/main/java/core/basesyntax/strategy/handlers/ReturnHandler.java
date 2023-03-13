package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.StrategyCalculator;

public class ReturnHandler implements StrategyCalculator {
    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        Storage.STORAGE.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity()
                + Storage.STORAGE.get(fruitTransaction.getFruit()));
    }
}
