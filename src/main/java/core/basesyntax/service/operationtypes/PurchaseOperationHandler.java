package core.basesyntax.service.operationtypes;

import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.Fruit;

//
public class PurchaseOperationHandler implements OperationTypeHandler {
    private FruitsDaoImpl fruitsDao = new FruitsDaoImpl();

    @Override
    public void makeOperation(String fruitType, int amount) {
        Fruit someFruit = fruitsDao.get(fruitType);
        if (someFruit.getAmount() - amount < 0) {
            throw new RuntimeException("Product out of stock");
        }
        someFruit.setAmount(someFruit.getAmount() - amount);
    }
}
