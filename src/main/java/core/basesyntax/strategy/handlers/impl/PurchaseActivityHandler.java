package core.basesyntax.strategy.handlers.impl;

import core.basesyntax.db.DatabaseDaoService;
import core.basesyntax.strategy.handlers.ActivityHandler;

public class PurchaseActivityHandler implements ActivityHandler {
    private final DatabaseDaoService databaseDao;

    public PurchaseActivityHandler(DatabaseDaoService databaseDao) {
        this.databaseDao = databaseDao;
    }

    @Override
    public void updateProductInfo(String product, Integer amount) {
        if (databaseDao.getProductAmount(product) >= amount) {
            databaseDao.reduceAmount(product, amount);
        } else {
            throw new RuntimeException("Not enough product " + product + " to sell");
        }
    }
}
