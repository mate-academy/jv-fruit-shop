package core.basesyntax.impl;

import core.basesyntax.data.FruitData;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void dataHandler(FruitData fruit) {
        int value = Storage.REPORT.get(fruit.getName());
        Storage.REPORT.put(fruit.getName(), value - fruit.getQuantity());
    }
}
