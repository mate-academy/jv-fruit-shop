package core.basesyntax.operation.impl;

public class SupplyOperation implements OperationHandler {
    @Override
    public Integer calculateOperation(int quantity) {
        return quantity;
    }
}
