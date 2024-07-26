package core.basesyntax.service.operation;

public class SupplyOperation implements OperationHandler {
    @Override
    public int getQuantity(int defaultQuantity, int fruitQuantity) {
        validateQuantity(defaultQuantity, fruitQuantity);
        return defaultQuantity + fruitQuantity;
    }

    private void validateQuantity(int defaultQuantity, int fruitQuantity) {
        int resultSupplyQuantity = defaultQuantity + fruitQuantity;
        if (resultSupplyQuantity < 0) {
            throw new RuntimeException("Result quantity can't be less than 0");
        }
    }
}
