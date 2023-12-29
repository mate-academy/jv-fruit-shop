package core.basesyntax.strategy.handlers.impl;

import core.basesyntax.db.DatabaseDaoService;
import core.basesyntax.strategy.handlers.ActivityHandler;

public class BalanceActivityHandler implements ActivityHandler {
    private final DatabaseDaoService databaseDao;

    public BalanceActivityHandler(DatabaseDaoService databaseDao) {
        this.databaseDao = databaseDao;
    }

    @Override
    public void updateProductInfo(String product, Integer amount) {
        databaseDao.put(product, amount);
    }
}
