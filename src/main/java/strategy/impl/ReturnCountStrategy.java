package strategy.impl;

import strategy.OperationCalculate;

public class ReturnCountStrategy implements OperationCalculate {
    @Override
    public int calculate(int currentAmount, int operationAmount) {
        return currentAmount + operationAmount;
    }
}
