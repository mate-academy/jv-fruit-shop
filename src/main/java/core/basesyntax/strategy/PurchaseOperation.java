package core.basesyntax.strategy;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void update(String fruit, Integer quantity) {
        int amountOfFruitAfterSell = storage.getStorage().get(fruit) - quantity;
        storage.getStorage().put(fruit, amountOfFruitAfterSell);
    }
}
