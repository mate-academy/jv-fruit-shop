package core.basesyntax.strategy.handlers.impl;

import core.basesyntax.constants.Product;
import core.basesyntax.service.DatabaseDaoService;
import core.basesyntax.service.impl.DatabaseDaoServiceImpl;
import core.basesyntax.strategy.handlers.ActivityHandler;

public class PurchaseActivityHandler implements ActivityHandler {
    private final DatabaseDaoService databaseDao;

    public PurchaseActivityHandler() {
        databaseDao = new DatabaseDaoServiceImpl();
    }

    @Override
    public void updateProductInfo(Product product, Integer amount) {
        if (databaseDao.getProduct(product).getAmount() >= amount) {
            databaseDao.reduceAmount(product, amount);
        } else {
            throw new RuntimeException("Not enough product " + product + " to sell");
        }
    }
}
