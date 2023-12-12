package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class ReturnOperationHandler implements DataOperationHandler {
    private FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void fruitOperation(Fruit fruit) {
        fruitDao.add(fruit.getTypeFruit(),
                fruitDao.get(fruit.getTypeFruit()) + fruit.getQuantity());
    }
}
