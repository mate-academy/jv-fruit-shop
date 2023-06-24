package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.exception.FruitException;
import core.basesyntax.strategy.Operation;

public class MinusOperationStrategy extends Operation {
    public MinusOperationStrategy(FruitDao fruitDao) {
        super(fruitDao);
    }

    @Override
    public void executeOperation(String fruit, int amount) {
        if (fruit == null || amount <= 0) {
            throw new FruitException("Invalid input data");
        }
        if (!fruitDao.contains(fruit) || fruitDao.get(fruit) < amount) {
            throw new FruitException("In storage only " + fruitDao.get(fruit) + " "
                    + fruit + ". Amount operation " + amount);
        }
        fruitDao.put(fruit, fruitDao.get(fruit) - amount);
    }
}
