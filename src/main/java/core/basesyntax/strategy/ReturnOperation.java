package core.basesyntax.strategy;

public class ReturnOperation implements OperationHandler {
    @Override
    public void update(String fruit, Integer quantity) {
        int newValueAfterReturning = storage.getStorage().get(fruit) + quantity;
        storage.getStorage().put(fruit, newValueAfterReturning);
    }
}
