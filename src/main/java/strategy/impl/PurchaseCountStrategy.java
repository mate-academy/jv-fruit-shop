package strategy.impl;

import strategy.OperationCalculate;

public class PurchaseCountStrategy implements OperationCalculate {
    @Override
    public int calculate(int currentAmount, int operationAmount) {
        return currentAmount - operationAmount;
    }
}
