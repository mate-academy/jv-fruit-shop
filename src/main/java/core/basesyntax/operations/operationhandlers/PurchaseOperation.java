package core.basesyntax.operations.operationhandlers;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        storageDao.subtract(fruit, quantity);
    }
}
