package core.basesyntax.strategy;

public interface OperationHandler {
    int FRUIT = 1;
    int QUANTITY = 2;

    void processCommand(String[] data);
}
