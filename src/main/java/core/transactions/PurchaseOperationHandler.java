package core.transactions;

import core.exception.OperationHandlerException;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getTransaction(int currentAmount, int operationAmount) {
        int subtraction = currentAmount - operationAmount;
        if (subtraction < 0) {
            throw new OperationHandlerException("Balance can not be less than 0");
        }
        return subtraction;
    }
}
