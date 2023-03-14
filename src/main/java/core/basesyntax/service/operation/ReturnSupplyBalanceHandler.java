package core.basesyntax.service.operation;

public class ReturnSupplyBalanceHandler implements OperationHandler {
    @Override
    public int doCalculation(int amount) {
        return amount;
    }

    @Override
    public boolean isApplicable(String operation) {
        return "r".equalsIgnoreCase(operation)
                || "s".equalsIgnoreCase(operation)
                || "b".equalsIgnoreCase(operation);
    }
}
