package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class SupplyOperationHandler implements DataOperationHandler {
    private FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void fruitOperation(Fruit fruit) {
        fruitDao.add(fruit.getTypeFruit(),
                fruitDao.get(fruit.getTypeFruit()) + fruit.getQuantity());
    }
}
