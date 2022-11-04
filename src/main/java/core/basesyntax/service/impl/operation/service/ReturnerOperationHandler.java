package core.basesyntax.service.impl.operation.service;

import core.basesyntax.service.OperationHandler;

public class ReturnerOperationHandler implements OperationHandler {
    @Override
    public int handle(int oldAmount, int quantityFromTransaction) {
        return oldAmount + quantityFromTransaction;
    }
}
