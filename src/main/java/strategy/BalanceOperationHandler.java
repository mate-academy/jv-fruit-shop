package strategy;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int getOperation(int initialQuantity, int amount) {
        return initialQuantity + amount;
    }
}
