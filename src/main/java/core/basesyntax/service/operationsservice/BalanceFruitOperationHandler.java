package core.basesyntax.service.operationsservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceFruitOperationHandler implements FruitOperationHandler {
    private FruitDao fruitDao;

    public BalanceFruitOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitDao.setQuantityForFruit(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
