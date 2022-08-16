package core.basesyntax.service.operationsservice;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseFruitOperation implements FruitOperation {
    private FruitsDao fruitsDao;

    public PurchaseFruitOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void updateFruitsQuantity(FruitTransaction fruitTransaction) {
        int currentQuantityForFruit = fruitsDao.getQuantityForFruit(fruitTransaction.getFruit());
        fruitsDao.setQuantityForFruit(fruitTransaction.getFruit(),
                currentQuantityForFruit - fruitTransaction.getQuantity());
    }
}
