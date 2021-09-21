package core.basesyntax.service.operationtypes;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationTypeHandler {
    private FruitsDao fruitsDao = new FruitsDaoImpl();

    @Override
    public void makeOperation(String fruitSort, int amount) {
        fruitsDao.add(new Fruit(fruitSort, amount));
    }
}
