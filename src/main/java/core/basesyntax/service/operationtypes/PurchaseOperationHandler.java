package core.basesyntax.service.operationtypes;

import core.basesyntax.db.FruitsDao;
import core.basesyntax.db.FruitsDaoImpl;
import core.basesyntax.model.Fruit;

public class PurchaseOperationHandler implements OperationTypeHandler {
    private FruitsDao fruitsDao = new FruitsDaoImpl();

    @Override
    public void makeOperation(String fruitType, int amount) {
        Fruit someFruit = fruitsDao.get(fruitType);
        if (someFruit.getAmount() - amount < 0) {
            throw new RuntimeException("Product out of stock");
        }
        someFruit.setAmount(someFruit.getAmount() - amount);
    }
}
