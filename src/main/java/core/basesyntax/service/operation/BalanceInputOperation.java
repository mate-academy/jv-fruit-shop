package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;

public class BalanceInputOperation implements InputOperation {
    private FruitDao fruitDao;

    public BalanceInputOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(FruitOperation fruitOperation) {
        Fruit fruit = fruitOperation.getFruit();
        fruitDao.add(fruit);
    }
}
