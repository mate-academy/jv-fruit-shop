package core.basesyntax.impl;

import core.basesyntax.data.FruitData;
import core.basesyntax.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void dataHandler(FruitData fruit) {
        Storage.REPORT.put(fruit.getName(), fruit.getQuantity());
    }
}
