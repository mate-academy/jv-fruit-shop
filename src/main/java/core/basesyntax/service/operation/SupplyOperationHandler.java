package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public Integer calculateNewAmount(FruitDao fruitDao, Fruit fruit, Integer amount) {
        Integer fruitDaoAmount = fruitDao.getAmount(fruit);
        return fruitDaoAmount + amount;
    }
}

