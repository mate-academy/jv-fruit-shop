package core.basesyntax.service.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int calculationData(int balance, FruitTransaction transaction) {
        balance = transaction.getQuantity();
        return balance;
    }
}
