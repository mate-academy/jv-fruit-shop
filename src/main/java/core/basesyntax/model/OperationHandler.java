package core.basesyntax.model;

public interface OperationHandler {
    void processRequest(String operation, String fruitName, int fruitQuantity);

    String getCurrentStorageState();
}
