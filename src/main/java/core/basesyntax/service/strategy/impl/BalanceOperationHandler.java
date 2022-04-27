package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private static final int INDEX_NAME = 1;
    private FruitShopDao fruitShopDao = new FruitShopDaoImpl();

    public void getOperation(String[] data) {
        fruitShopDao.add(data[INDEX_NAME],
                Storage.fruitStorage.get(data[INDEX_NAME]));

    }
}
