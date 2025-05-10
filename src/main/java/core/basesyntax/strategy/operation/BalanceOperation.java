package core.basesyntax.strategy.operation;

public class BalanceOperation implements OperationHandler {
    @Override
    public int executeOperation(int initBalance, int quantity) {
        return quantity;
    }
}
