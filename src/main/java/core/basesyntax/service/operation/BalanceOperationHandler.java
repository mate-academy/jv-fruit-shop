package core.basesyntax.service.operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int getOperation(int quantity) {
        return quantity;
    }
}
