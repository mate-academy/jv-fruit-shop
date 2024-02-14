package strategy;

public class BalanceHandlerImpl implements OperationHandler {
    private static final int BORDER_POSITIVE = 0;

    @Override
    public int getAmount(int quantity) {
        if (quantity < BORDER_POSITIVE) {
            throw new RuntimeException("Balance can't be negative quantity!");
        }
        return quantity;
    }
}
