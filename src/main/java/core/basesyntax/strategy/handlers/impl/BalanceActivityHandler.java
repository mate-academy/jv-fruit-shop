package core.basesyntax.strategy.handlers.impl;

import core.basesyntax.constants.Products;
import core.basesyntax.service.DatabaseDaoService;
import core.basesyntax.service.impl.DatabaseDaoServiceImpl;
import core.basesyntax.strategy.handlers.ActivitiesHandler;

public class BalanceActivityHandler implements ActivitiesHandler {
    private final DatabaseDaoService databaseDao;

    public BalanceActivityHandler() {
        databaseDao = new DatabaseDaoServiceImpl();
    }

    @Override
    public void updateProductInfo(Products product, Integer amount) {
        databaseDao.put(product, amount);
    }
}
