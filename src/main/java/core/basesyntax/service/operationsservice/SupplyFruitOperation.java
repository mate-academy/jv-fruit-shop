package core.basesyntax.service.operationsservice;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyFruitOperation implements FruitOperation {
    private FruitsDao fruitsDao;

    public SupplyFruitOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void updateFruitsQuantity(FruitTransaction fruitTransaction) {
        int currentQuantityForFruit = fruitsDao.getQuantityForFruit(fruitTransaction.getFruit());
        fruitsDao.setQuantityForFruit(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity() + currentQuantityForFruit);
    }
}
