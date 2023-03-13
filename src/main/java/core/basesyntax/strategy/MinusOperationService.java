package core.basesyntax.strategy;

import core.basesyntax.exception.FruitException;

public class MinusOperationService extends OperationService {
    @Override
    public void executeOperation(String fruit, int amount) {
        if (fruit == null || amount <= 0) {
            throw new FruitException("Invalid input data");
        }
        if (!fruitDao.isContains(fruit) || fruitDao.get(fruit) < amount) {
            throw new FruitException("In storage only " + fruitDao.get(fruit) + " "
                    + fruit + ". Amount operation " + amount);
        }
        fruitDao.put(fruit, fruitDao.get(fruit) - amount);
    }
}
