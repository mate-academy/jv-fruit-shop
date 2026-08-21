package core.basesyntax.strategy;

public interface OperationHandler {
    int apply(int currentQuantity, int transactionQuantity);
}
