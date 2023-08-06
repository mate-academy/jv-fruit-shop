package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public int getValueByOperation(String[] dataArray) {
        return -(Integer.parseInt(dataArray[QUANTITY_INDEX]));
    }
}
