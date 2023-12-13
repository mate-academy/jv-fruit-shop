package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements DataOperationHandler {
    private FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void fruitOperation(Fruit fruit) {
        if (fruitDao.get(fruit.getTypeFruit()) < fruit.getQuantity()) {
            throw new RuntimeException("There is no such quantity available "
                    + fruit.getTypeFruit() + ". There are currently available:"
                    + fruitDao.get(fruit.getTypeFruit()));
        }
        fruitDao.add(fruit.getTypeFruit(),
                fruitDao.get(fruit.getTypeFruit()) - fruit.getQuantity());
    }
}
