package core.basesyntax.service.operation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int getOperation(int amount) {
        return amount;
    }
}
