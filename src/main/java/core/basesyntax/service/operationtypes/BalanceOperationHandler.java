package core.basesyntax.service.operationtypes;

import core.basesyntax.db.FruitsDao;
import core.basesyntax.db.FruitsDaoImpl;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationTypeHandler {
    private FruitsDao fruitsDao = new FruitsDaoImpl();

    @Override
    public void makeOperation(String fruitSort, int amount) {
        fruitsDao.add(new Fruit(fruitSort, amount));
    }
}
