package core.basesyntax.service.operation;

public class PurchaseOperation implements OperationHandler {
    @Override
    public int getQuantity(int defaultQuantity, int fruitQuantity) {
        validateQuantity(defaultQuantity, fruitQuantity);
        return defaultQuantity - fruitQuantity;
    }
}
