package core.basesyntax.service.operation;

public class DefaultOperationHandler implements OperationHandler {
    @Override
    public int doCalculation(int amount) {
        System.out.println("Default operation was invoked. "
                + "Please, choose another type of operation.");
        return amount;
    }

    @Override
    public boolean isApplicable(String operation) {
        return true;
    }
}
