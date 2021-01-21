package core.strategy;

public class BalanceAmountHandler implements AmountHandler {
    @Override
    public int calculateAmount(int currentAmount, int operationAmount) {
        return currentAmount + operationAmount;
    }
}
