package core.basesyntax.service.operationsservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseFruitOperation implements FruitOperation {
    private FruitDao fruitDao;

    public PurchaseFruitOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void updateFruitsQuantity(FruitTransaction fruitTransaction) {
        int currentQuantityForFruit = fruitDao.getQuantityForFruit(fruitTransaction.getFruit());
        fruitDao.setQuantityForFruit(fruitTransaction.getFruit(),
                currentQuantityForFruit - fruitTransaction.getQuantity());
    }
}
