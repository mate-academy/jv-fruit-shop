package core.basesyntax.impl;

import core.basesyntax.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int changeWarehouseStatus(String operation, int actualQuantity,
                                     int quantityToOperate) {
        return actualQuantity - quantityToOperate;
    }
}
