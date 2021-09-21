package core.basesyntax.service.operationtypes;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.Fruit;

public class ReturnOperationHandler implements OperationTypeHandler {
    private FruitsDao fruitsDao = new FruitsDaoImpl();

    @Override
    public void makeOperation(String fruitType, int amount) {
        Fruit someFruit = fruitsDao.get(fruitType);
        someFruit.setAmount(someFruit.getAmount() + amount);
    }
}
