package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceStrategy implements QuantityCalculationStrategy {
    @Override
    public void calculate(FruitTransaction fruitTransaction) {
        Storage.STORAGE.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
