package core.basesyntax.service.handler.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.handler.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public Fruit apply(int fruitNumber, String fruitName) {
        Fruit currentFruit = fruitDao.get(fruitName).orElseThrow(()
                -> new RuntimeException("You can`t return that fruit!"));
        int oldCountFruit = fruitDao.getFruitsCount(fruitName);
        fruitDao.updateFruitCount(oldCountFruit + fruitNumber, fruitName);
        return currentFruit;
    }
}
