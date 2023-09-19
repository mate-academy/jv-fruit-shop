package fruitshop.strategy.operation.impl;

import fruitshop.strategy.operation.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int doSomeOperation(int currentAmount, int amount) {
        int result = currentAmount - amount;
        if (result > 0) {
            return result;
        } else {
            throw new RuntimeException("Invalid data for amount, it should be more than 0."
                    + " Amounts: " + result);
        }
    }
}
