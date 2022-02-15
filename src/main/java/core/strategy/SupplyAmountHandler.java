package core.strategy;

public class SupplyAmountHandler implements AmountHandler {
    @Override
    public int calculateAmount(int currentAmount, int operationAmount) {
        return currentAmount + operationAmount;
    }
}
