package core.basesyntax.strategy;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    private final ShopDao shopDao;

    public BalanceHandler(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        shopDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
