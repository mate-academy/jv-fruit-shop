package core.basesyntax.strategy.impl;

import core.basesyntax.data.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void dataHandler(FruitTransaction fruit) {
        Storage.REPORT.put(fruit.getName(), fruit.getQuantity());
    }
}
