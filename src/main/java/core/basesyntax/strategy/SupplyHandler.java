package core.basesyntax.strategy;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyHandler implements OperationHandler {
    private final ShopDao shopDao;

    public SupplyHandler(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        shopDao.add(fruitTransaction.getFruit(),
                shopDao.getFruits().get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
