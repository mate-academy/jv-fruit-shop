package fruitshop.strategy.operation.impl;

import fruitshop.strategy.operation.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int doSomeOperation(int currentAmount, int amount) {
        return currentAmount + amount;
    }
}
