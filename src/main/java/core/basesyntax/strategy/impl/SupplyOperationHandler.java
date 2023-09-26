package core.basesyntax.strategy.impl;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void dataHandler(FruitTransaction fruit) {
        int value = Storage.REPORT.get(fruit.getName());
        Storage.REPORT.put(fruit.getName(), value + fruit.getQuantity());
    }
}
