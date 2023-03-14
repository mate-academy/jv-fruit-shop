package core.basesyntax.service.operation;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int doCalculation(int amount) {
        return amount;
    }

    @Override
    public boolean isApplicable(String operation) {
        return "r".equalsIgnoreCase(operation);
    }
}
