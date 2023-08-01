package core.basesyntax.strategy;

public class BalanceOperation implements OperationHandler {
    @Override
    public void update(String fruit, Integer quantity) {
        storage.getStorage().put(fruit, quantity);
    }
}
