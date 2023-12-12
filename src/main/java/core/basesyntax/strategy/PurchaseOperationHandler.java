package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements DataOperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void fruitOperation(Fruit fruit) {
        fruitDao.add(fruit.getTypeFruit(),
                fruitDao.get(fruit.getTypeFruit()) - fruit.getQuantity());
    }
}
