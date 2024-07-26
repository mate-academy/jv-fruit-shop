package core.basesyntax.service.operation;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int getQuantity(int defaultQuantity, int fruitQuantity) {
        validateQuantity(defaultQuantity, fruitQuantity);
        return defaultQuantity - fruitQuantity;
    }

    private void validateQuantity(int defaultQuantity, int fruitQuantity) {
        int resultPurchaseQuantity = defaultQuantity - fruitQuantity;
        if (resultPurchaseQuantity < 0) {
            throw new RuntimeException("Result quantity can't be less than 0");
        }
    }
}
