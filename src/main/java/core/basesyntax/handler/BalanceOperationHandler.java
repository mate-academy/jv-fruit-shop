package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements DataOperationHandler {
    private FruitDao fruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void fruitOperation(Fruit fruit) {
        fruitDao.add(fruit.getTypeFruit(), fruit.getQuantity());
    }
}
