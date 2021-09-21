package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public Integer calculateNewAmount(Fruit fruit, Integer amount) {
        Integer fruitDaoAmount = fruitDao.getAmount(fruit);
        return fruitDaoAmount + amount;
    }
}


