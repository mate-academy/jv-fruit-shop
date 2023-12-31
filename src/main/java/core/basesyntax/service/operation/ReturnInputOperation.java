package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;

public class ReturnInputOperation implements InputOperation {
    private FruitDao fruitDao;

    public ReturnInputOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitOperation fruitOperation) {
        Fruit fruit = fruitDao.get(fruitOperation.getFruit());
        fruitDao.update(fruit, fruitDao.get(fruit)
                .getQuantity()
                .add(fruitOperation.getFruit()
                        .getQuantity()));
    }
}
