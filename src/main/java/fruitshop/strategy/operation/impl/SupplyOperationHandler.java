package fruitshop.strategy.operation.impl;

import fruitshop.strategy.operation.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int operate(int currentAmount, int amount) {
        return currentAmount + amount;
    }
}
