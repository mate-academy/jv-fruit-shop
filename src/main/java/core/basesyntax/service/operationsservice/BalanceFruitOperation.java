package core.basesyntax.service.operationsservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceFruitOperation implements FruitOperation {
    private FruitDao fruitDao;

    public BalanceFruitOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void updateFruitsQuantity(FruitTransaction fruitTransaction) {
        fruitDao.setQuantityForFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
