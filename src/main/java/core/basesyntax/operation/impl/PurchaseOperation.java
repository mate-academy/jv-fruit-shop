package core.basesyntax.operation.impl;

public class PurchaseOperation implements OperationHandler {
    @Override
    public Integer calculateOperation(int quantity) {
        return -quantity;
    }
}
