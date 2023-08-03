package core.transactions;

import core.exception.OperationHandlerException;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int getTransaction(int currentAmount, int operationAmount) {
        int sum = currentAmount + operationAmount;
        if (sum < 0) {
            throw new OperationHandlerException("balance can not be less than 0");
        }
        return sum;
    }
}
