package core.basesyntax.service.operationsservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyFruitOperationHandler implements FruitOperationHandler {
    private FruitDao fruitDao;

    public SupplyFruitOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int currentQuantityForFruit = fruitDao.getQuantityForFruit(fruitTransaction.getFruit());
        fruitDao.setQuantityForFruit(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity() + currentQuantityForFruit);
    }
}
