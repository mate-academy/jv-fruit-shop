package core.basesyntax.transaction;

public interface OperationHandler {
    int perform(int balance, int quantity);
}
