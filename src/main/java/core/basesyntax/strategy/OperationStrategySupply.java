package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDaoImpl;

public class OperationStrategySupply implements OperationStrategy {
    @Override
    public void calculate(String fruit, int value) {
        FruitDaoImpl storage = new FruitDaoImpl();
        Integer fruitsQuantity = storage.getStorage().get(fruit);
        storage.add(fruit, fruitsQuantity + value);
    }
}
