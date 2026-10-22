package core.basesyntax.strategy;

public class BalanceOperation implements OperationHandler {
    @Override
    public int updateQuantity(int currentQuantity, int quantity) {
        return currentQuantity + quantity;
    }
}
