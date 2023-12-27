package core.basesyntax.strategy.handlers.impl;

import core.basesyntax.constants.Product;
import core.basesyntax.service.DatabaseDaoService;
import core.basesyntax.service.impl.DatabaseDaoServiceImpl;
import core.basesyntax.strategy.handlers.ActivityHandler;

public class SupplyActivityHandler implements ActivityHandler {
    private final DatabaseDaoService databaseDao;

    public SupplyActivityHandler() {
        databaseDao = new DatabaseDaoServiceImpl();
    }

    @Override
    public void updateProductInfo(Product product, Integer amount) {
        databaseDao.increaseAmount(product, amount);
    }
}
