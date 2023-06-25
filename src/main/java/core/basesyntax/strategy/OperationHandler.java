package core.basesyntax.strategy;

public interface OperationHandler {
    int executeOperation(int currentQuantity, int quantityFromTransaction);
}
