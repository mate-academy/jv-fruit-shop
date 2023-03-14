package core.basesyntax.service.operation;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int doCalculation(int amount) {
        return -amount;
    }

    @Override
    public boolean isApplicable(String operation) {
        return "p".equalsIgnoreCase(operation);
    }
}
