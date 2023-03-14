package core.basesyntax.service.operation;

public interface OperationHandler {
    int doCalculation(int amount);

    boolean isApplicable(String operation);
}
