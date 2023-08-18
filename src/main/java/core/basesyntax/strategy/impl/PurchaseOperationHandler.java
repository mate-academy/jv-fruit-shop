package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void getValueByOperation(FruitTransaction dataArray) {
        Integer oldValue = Storage.getMap().get(dataArray.getFruit());
        Storage.getMap().put(dataArray.getFruit(), oldValue == null
                ? -dataArray.getQuantity() : oldValue - dataArray.getQuantity());
    }
}
