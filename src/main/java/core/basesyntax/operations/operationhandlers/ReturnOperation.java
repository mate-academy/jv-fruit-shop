package core.basesyntax.operations.operationhandlers;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        storageDao.add(fruit, quantity);
    }
}
