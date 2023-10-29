package fruitshop.strategy.operation.impl;

import fruitshop.strategy.operation.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int operate(int currentAmount, int amount) {
        return amount;
    }
}
