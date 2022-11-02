package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationStrategy implements OperationHandler {
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void processFruitTransactionOperation(FruitTransaction fruitTransaction) {
        String key = fruitTransaction.getFruit();
        int oldQuantity = Storage.fruits.get(key);
        fruitDao.putFruit(key, oldQuantity + fruitTransaction.getQuantity());
    }
}
