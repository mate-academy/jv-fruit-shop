package core.basesyntax.service.transactions;

import core.basesyntax.exceptions.FruitTransactionException;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int countQuantity(int currentAmount, int operationAmount) {
        int sum = currentAmount + operationAmount;
        if (sum < 0) {
            throw new FruitTransactionException("balance can not be less than 0");
        }
        return sum;
    }
}
