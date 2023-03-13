package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.StrategyCalculator;

public class BalanceHandler implements StrategyCalculator {
    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        Storage.STORAGE.put(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
