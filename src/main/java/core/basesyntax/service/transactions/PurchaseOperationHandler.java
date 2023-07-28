package core.basesyntax.service.transactions;

import core.basesyntax.exceptions.FruitTransactionException;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getTransaction(int currentAmount, int operationAmount) {
        int subtraction = currentAmount - operationAmount;
        if (subtraction < 0) {
            throw new FruitTransactionException("balance can not be less than 0");
        }
        return subtraction;
    }
}
