package core.basesyntax.operation.handler;

public class PurchaseOperation extends AbstractOperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        storageDao.subtract(fruit, quantity);
    }
}
