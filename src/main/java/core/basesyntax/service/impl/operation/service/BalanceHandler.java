package core.basesyntax.service.impl.operation.service;

import core.basesyntax.service.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public int newAmount(int oldAmount, int quantityFromTransaction) {
        return oldAmount + quantityFromTransaction;
    }
}
