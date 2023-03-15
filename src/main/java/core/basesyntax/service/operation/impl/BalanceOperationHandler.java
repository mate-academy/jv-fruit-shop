package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private FruitShopDaoImpl fruitShopDao;

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        fruitShopDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
