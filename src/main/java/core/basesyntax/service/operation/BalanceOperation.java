package core.basesyntax.service.operation;

public class BalanceOperation implements OperationHandler {
    @Override
    public int getQuantity(int defaultQuantity, int fruitQuantity) {
        return defaultQuantity + fruitQuantity;
    }
}
