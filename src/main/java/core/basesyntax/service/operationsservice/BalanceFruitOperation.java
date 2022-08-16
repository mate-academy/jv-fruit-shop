package core.basesyntax.service.operationsservice;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceFruitOperation implements FruitOperation {
    private FruitsDao fruitsDao;

    public BalanceFruitOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void updateFruitsQuantity(FruitTransaction fruitTransaction) {
        fruitsDao.setQuantityForFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
