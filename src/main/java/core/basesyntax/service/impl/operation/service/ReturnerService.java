package core.basesyntax.service.impl.operation.service;

import core.basesyntax.service.OperationService;

public class ReturnerService implements OperationService {
    @Override
    public int newAmount(int oldAmount, int quantityFromTransaction) {
        return oldAmount + quantityFromTransaction;
    }
}
