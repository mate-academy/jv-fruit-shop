package core.basesyntax.service.activity;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class ReturnHandler implements OperationHandler {
    private FruitDao fruitDao;

    public ReturnHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(Fruit fruit) {
        if (fruitDao.getByName(fruit.getName()) != null) {
            fruitDao.addAmount(fruit);
        } else {
            fruitDao.addFruit(fruit);
        }
    }
}

