package core.basesyntax.strategy.handlers.impl;

import core.basesyntax.db.DatabaseDaoService;
import core.basesyntax.db.DatabaseDaoServiceImpl;
import core.basesyntax.strategy.handlers.ActivityHandler;

public class SupplyActivityHandler implements ActivityHandler {
    private final DatabaseDaoService databaseDao;

    public SupplyActivityHandler() {
        databaseDao = new DatabaseDaoServiceImpl();
    }

    @Override
    public void updateProductInfo(String product, Integer amount) {
        databaseDao.increaseAmount(product, amount);
    }
}
