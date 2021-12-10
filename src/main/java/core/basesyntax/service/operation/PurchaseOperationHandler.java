package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public Integer calculateNewAmount(Fruit fruit, Integer amount) {
        Integer fruitDaoAmount = fruitDao.getAmount(fruit);
        if (fruitDaoAmount >= amount) {
            return fruitDaoAmount - amount;
        }
        throw new RuntimeException("Wrong purchase! In storage are "
                + fruitDaoAmount + " " + fruit.getName() + "s, you cannot buy " + amount);
    }
}
