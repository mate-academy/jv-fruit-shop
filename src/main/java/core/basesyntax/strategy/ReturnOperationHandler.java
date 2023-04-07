package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void calculate(String fruit, int value) {
        Integer fruitsQuantity = fruitDao.getStorage().get(fruit);
        fruitDao.add(fruit, fruitsQuantity + value);
    }
}
