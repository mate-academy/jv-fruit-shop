package strategy.impl;

import strategy.OperationCalculate;

public class BalanceCountStrategy implements OperationCalculate {
    @Override
    public int calculate(int currentAmount, int operationAmount) {
        return operationAmount;
    }
}
