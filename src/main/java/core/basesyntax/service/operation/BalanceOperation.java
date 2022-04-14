package core.basesyntax.service.operation;

public class BalanceOperation implements OperationHandler {
    @Override
    public int process(int fruitTransactionQuantity, int currentFruitQuantity) {
        return fruitTransactionQuantity;
    }
}
