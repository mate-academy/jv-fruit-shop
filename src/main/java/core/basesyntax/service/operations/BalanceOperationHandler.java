package core.basesyntax.service.operations;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.IFruitDao;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements IOperationHandler {

    private final IFruitDao fruitDao = new FruitDao();

    @Override
    public void performOperation(String name, int quantity) {
        Fruit newFruit = new Fruit(name,quantity);
        fruitDao.add(newFruit);
    }
}
