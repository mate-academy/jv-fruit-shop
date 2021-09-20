package core.basesyntax.service.operationTypes;

import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationTypeHandler{
    FruitsDaoImpl fruitsDao = new FruitsDaoImpl();

    @Override
    public void makeOperation(String fruitType, int amount) {
        fruitsDao.add(new Fruit(fruitType, amount));
    }
}
