package core.basesyntax.strategy.operations;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void runOperation(FruitsDao fruitsDao, String fruitName, int quantity) {
        Fruit fruit = fruitsDao.getFruit(fruitName);
        fruit.setQuantity(fruit.getQuantity() - quantity);
        fruitsDao.update(fruit);
    }
}
