package core.basesyntax.strategy;

public interface OperationHandler {
    int execudeOperation(int currentQuantity, int quantityFromTransaction);
}
