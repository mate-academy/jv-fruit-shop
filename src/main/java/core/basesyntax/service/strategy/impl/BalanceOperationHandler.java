package core.basesyntax.service.strategy.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private FruitShopDao fruitShopDao = new FruitShopDaoImpl();

    public void handle(String fruitName, int quantity) {
        fruitShopDao.add(fruitName,
                Storage.fruitStorage.get(fruitName) == null ? quantity :
                Storage.fruitStorage.get(quantity));
    }
}
