package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;

public class PurchaseInputOperation implements InputOperation {
    private FruitDao fruitDao;

    public PurchaseInputOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitOperation fruitOperation) {
        Fruit fruit = fruitDao.get(fruitOperation.getFruit());
        fruitDao.update(fruit, fruitDao.get(fruit)
                .getQuantity()
                .subtract(fruitOperation.getFruit()
                        .getQuantity()));
    }
}
