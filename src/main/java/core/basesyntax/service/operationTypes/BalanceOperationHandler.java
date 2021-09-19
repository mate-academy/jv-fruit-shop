package core.basesyntax.service.operationTypes;

import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.Fruit;

public class BalanceOperationHandler implements OperationTypeHandler{
    FruitsDaoImpl fruitsDao = new FruitsDaoImpl();

    @Override
    public boolean operationMaker(String fruitType, int amount) {
        return fruitsDao.add(new Fruit(fruitType, amount));
    }
}
