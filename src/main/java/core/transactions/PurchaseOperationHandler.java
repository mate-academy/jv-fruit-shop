package core.transactions;

import core.exception.FruitException;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int getTransaction(int currentAmount, int operationAmount) {
        int subtraction = currentAmount - operationAmount;
        if (subtraction < 0) {
            throw new FruitException("Balance can not be less than 0");
        }
        return subtraction;
    }
}
