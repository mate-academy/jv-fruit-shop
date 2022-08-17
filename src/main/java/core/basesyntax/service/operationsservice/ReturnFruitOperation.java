package core.basesyntax.service.operationsservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnFruitOperation implements FruitOperation {
    private FruitDao fruitDao;

    public ReturnFruitOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void updateFruitsQuantity(FruitTransaction fruitTransaction) {
        int currentQuantityForFruit = fruitDao.getQuantityForFruit(fruitTransaction.getFruit());
        fruitDao.setQuantityForFruit(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity() + currentQuantityForFruit);
    }
}
