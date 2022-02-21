package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.handler.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public Fruit apply(int fruitNumber, String fruitName) {
        Fruit currentFruit = fruitDao.get(fruitName).orElseGet(()
                -> fruitDao.add(new Fruit(fruitName, 0)));
        int oldCountFruit = fruitDao.getFruitsCount(fruitName);
        fruitDao.updateFruitCount(oldCountFruit + fruitNumber, fruitName);
        return currentFruit;
    }
}
