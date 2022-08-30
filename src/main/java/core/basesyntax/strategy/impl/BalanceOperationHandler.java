package core.basesyntax.strategy.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaktion;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(Transaktion transaktion) {
        Fruit fruit = transaktion.getFruit();
        Storage.storage.put(fruit, transaktion.getQuantity());
    }
}
