package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDaoImpl;

public class OperationStrategyBalance implements OperationStrategy {
    @Override
    public void calculate(String fruit, int value) {
        FruitDaoImpl storage = new FruitDaoImpl();
        storage.add(fruit, value);
    }
}
