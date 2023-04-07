package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDaoImpl;

public class OperationStrategyPurchase implements OperationStrategy {
    private static final int ALLOWABLE_QUANTITY = 0;

    @Override
    public void calculate(String fruit, int value) {
        FruitDaoImpl storage = new FruitDaoImpl();
        int newFruitsQuantity = storage.getStorage().get(fruit) - value;
        if (newFruitsQuantity < ALLOWABLE_QUANTITY) {
            throw new RuntimeException("Purchase value can't be greater than fruits quantity");
        }
        storage.add(fruit, newFruitsQuantity);
    }
}
