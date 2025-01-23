package core.basesyntax.operations.operationhandlers;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        storageDao.add(fruit, quantity);
    }
}
