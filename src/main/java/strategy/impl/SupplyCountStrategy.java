package strategy.impl;

import strategy.OperationCalculate;

public class SupplyCountStrategy implements OperationCalculate {
    @Override
    public int calculate(int currentAmount, int operationAmount) {
        return currentAmount + operationAmount;
    }
}
