package core.basesyntax.service.operationTypes;

import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.Fruit;

//
public class PurchaseOperationHandler implements OperationTypeHandler{
    FruitsDaoImpl fruitsDao = new FruitsDaoImpl();

    @Override
    public void makeOperation(String fruitType, int amount) {
        Fruit someFruit = fruitsDao.get(fruitType);
        someFruit.setAmount(someFruit.getAmount() - amount);
    }
}
