package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.OperationHandler;

public class ReturnHandler implements OperationHandler<Fruit> {
    private FruitDao fruitDao;

    public ReturnHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(Fruit fruit) {
        fruitDao.save(fruit);
    }
}
