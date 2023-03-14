package core.basesyntax.service.operation;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int doCalculation(int amount) {
        return amount;
    }

    @Override
    public boolean isApplicable(String operation) {
        return "s".equalsIgnoreCase(operation);
    }
}
