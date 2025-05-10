package core.basesyntax.operation.impl;

public class BalanceOperation implements OperationHandler {
    @Override
    public Integer calculateOperation(int quantity) {
        return quantity;
    }
}
