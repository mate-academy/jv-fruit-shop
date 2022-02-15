package core.strategy;

public class ReturnAmountHandler implements AmountHandler {
    @Override
    public int calculateAmount(int currentAmount, int operationAmount) {
        return currentAmount + operationAmount;
    }
}
