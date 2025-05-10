package core.basesyntax.operation.impl;

public class ReturnOperation implements OperationHandler {
    @Override
    public Integer calculateOperation(int quantity) {
        return quantity;
    }
}
