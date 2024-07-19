package core.basesyntax.service.operation;

public class SupplyOperation implements OperationHandler {
    @Override
    public int getQuantity(int defaultQuantity, int fruitQuantity) {
        return defaultQuantity + fruitQuantity;
    }
}
