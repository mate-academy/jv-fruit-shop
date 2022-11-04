package core.basesyntax.service.impl.operation.service;

import core.basesyntax.service.OperationHandler;

public class PurchaserHandler implements OperationHandler {
    @Override
    public int newAmount(int oldAmount, int quantityFromTransaction) {
        return oldAmount - quantityFromTransaction;
    }
}
