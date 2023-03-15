package core.basesyntax.service.strategy;

import core.basesyntax.service.model.FruitTransaction;

public class SupplyFruitHandler implements FruitHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        int balance = storage.storage.get(fruitTransaction.getFruit());
        storage.storage.put(fruitTransaction.getFruit(), balance + fruitTransaction.getValue());
    }
}
