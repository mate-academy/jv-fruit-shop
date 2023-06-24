package core.basesyntax.service.strategy;

import core.basesyntax.service.model.FruitTransaction;

public class BalanceFruitHandler implements FruitHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        storage.storage.put(fruitTransaction.getFruit(), fruitTransaction.getValue());
    }
}
