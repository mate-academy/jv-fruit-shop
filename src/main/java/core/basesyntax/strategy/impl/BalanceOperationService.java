package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.OperationService;

public class BalanceOperationService implements OperationService {
    private final FruitDao fruitDao;

    public BalanceOperationService(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(String fruitName, int quantity) {
        Fruit fruit = new Fruit(fruitName, quantity);
        fruit.setSold(0);
        fruitDao.add(fruit);
    }
}
