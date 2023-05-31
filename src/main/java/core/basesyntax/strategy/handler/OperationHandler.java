package core.basesyntax.strategy.handler;

public interface OperationHandler {
    int operate(int transaction, int oldValue);
}
