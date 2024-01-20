package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void getOperation(FruitDao fruitDao, String fruit, int quantity) {
        fruitDao.addCsvRow(new Fruit(Fruit.Operation.PURCHASE, fruit, quantity));
    }
}
