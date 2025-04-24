package core.basesyntax.strategy.operation;

public class BalanceOperation implements OperationHandler {
    @Override
    public int makeOperation(int amountOfOperation) {
        return amountOfOperation;
    }
}
