package core.basesyntax.strategy;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int updateQuantity(int currentQuantity, int quantity) {
        currentQuantity -= quantity;

        if (currentQuantity < 0) {
            throw new RuntimeException("Balance cannot be less than zero");
        }
        return currentQuantity;
    }
}
