package core.basesyntax.strategy.operation;

public class SupplyOperation implements OperationHandler {
    @Override
    public int makeOperation(int amountOfOperation) {
        return amountOfOperation;
    }
}
