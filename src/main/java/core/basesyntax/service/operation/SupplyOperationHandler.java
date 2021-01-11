package core.basesyntax.service.operation;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int getOperation(int amount) {
        return amount;
    }
}
