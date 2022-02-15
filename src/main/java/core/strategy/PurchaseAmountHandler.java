package core.strategy;

public class PurchaseAmountHandler implements AmountHandler {
    @Override
    public int calculateAmount(int currentAmount, int operationAmount) {
        if (operationAmount > currentAmount) {
            throw new RuntimeException("Buyers can't buy this amount of fruits: "
                    + operationAmount);
        }
        return currentAmount - operationAmount;
    }
}
