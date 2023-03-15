package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class ExpiredOperationHandler implements OperationHandler {
    private FruitShopDao fruitShopDao;

    public ExpiredOperationHandler(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        int amount = Storage.fruits.get(fruitTransaction.getFruit());
        int result = amount - fruitTransaction.getQuantity();
        fruitShopDao.add(fruitTransaction.getFruit(), result);
    }
}
