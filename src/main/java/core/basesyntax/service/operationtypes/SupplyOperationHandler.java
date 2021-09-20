package core.basesyntax.service.operationtypes;

import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.Fruit;

//
public class SupplyOperationHandler implements OperationTypeHandler {
    private FruitsDaoImpl fruitsDao = new FruitsDaoImpl();

    @Override
    public void makeOperation(String fruitType, int amount) {
        Fruit someFruit = fruitsDao.get(fruitType);
        someFruit.setAmount(someFruit.getAmount() + amount);
    }
}
