package core.basesyntax.service.impl.transactions;

import core.basesyntax.service.OperationHandler;

public class BalanceHandlerImpl implements OperationHandler {
    @Override
    public int getBalance(int storageBalance, int quantity) {
        return quantity;
    }
}
