package core.basesyntax.service.operation;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int doCalculation(int amount) {
        return amount;
    }

    @Override
    public boolean isApplicable(String operation) {
        return "b".equalsIgnoreCase(operation);
    }
}
