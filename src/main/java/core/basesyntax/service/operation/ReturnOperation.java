package core.basesyntax.service.operation;

public class ReturnOperation implements OperationHandler {
    @Override
    public int process(int fruitTransactionQuantity, int currentFruitQuantity) {
        return fruitTransactionQuantity + currentFruitQuantity;
    }
}
