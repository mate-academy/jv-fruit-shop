package core.transactions;

import core.exception.OperationHandlerException;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int getTransaction(int currentAmount, int operationAmount) {
        int sum = currentAmount + operationAmount;
        if (sum < 0) {
            throw new OperationHandlerException("Balance can not be less than 0");
        }
        return sum;
    }
}
