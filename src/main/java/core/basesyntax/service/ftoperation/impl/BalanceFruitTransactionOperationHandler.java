package core.basesyntax.service.ftoperation.impl;

import core.basesyntax.service.ftoperation.FruitTransactionOperationHandler;

public class BalanceFruitTransactionOperationHandler implements FruitTransactionOperationHandler {
    @Override
    public int handle(int quantity) {
        return quantity;
    }
}
