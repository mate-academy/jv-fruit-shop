package core.basesyntax.model.strategy;

import core.basesyntax.dao.FruitDao;

public class ReduceQuantityStrategy implements OperationStrategy {
    @Override
    public void process(FruitDao fruitDao, String name, int quantity) {
        int currentQuantity = fruitDao.getQuantity(name);
        if (currentQuantity < quantity) {
            throw new RuntimeException("There is less " + name
                    + " in the warehouse than you would like to pick up: "
                    + currentQuantity
                    + " < "
                    + quantity);
        }
        fruitDao.put(name, currentQuantity - quantity);
    }
}
