package core.basesyntax.strategy;

import core.basesyntax.exception.FruitException;

public class PlusOperationService extends OperationService {
    @Override
    public void executeOperation(String fruit, int amount) {
        if (fruit == null || amount <= 0) {
            throw new FruitException("Invalid input data");
        }
        if (fruitDao.isContains(fruit)) {
            fruitDao.put(fruit, fruitDao.get(fruit) + amount);
        } else {
            fruitDao.put(fruit, amount);
        }
    }
}
