package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private static final int INDEX_NAME = 1;
    private static final int INDEX_QUANTITY = 2;
    private FruitShopDao fruitShopDao = new FruitShopDaoImpl();

    @Override
    public void getOperation(String[] data) {
        int pars = Integer.parseInt(data[INDEX_QUANTITY]);
        fruitShopDao.add(data[INDEX_NAME],
                Storage.fruitStorage.get(data[INDEX_NAME]) - pars);
    }
}
