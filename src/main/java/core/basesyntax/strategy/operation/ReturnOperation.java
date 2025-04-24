package core.basesyntax.strategy.operation;

public class ReturnOperation implements OperationHandler {
    @Override
    public int makeOperation(int amountOfOperation) {
        return amountOfOperation;
    }
}
