package core.basesyntax.handlers;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;

public class BalanceHandler implements OperationHandler {
    private static final FruitShopDao fruitShopDao = new FruitShopDaoImpl();

    @Override
    public void process(String key, Integer value) {
        fruitShopDao.addToStorage(key, value);
    }
}
