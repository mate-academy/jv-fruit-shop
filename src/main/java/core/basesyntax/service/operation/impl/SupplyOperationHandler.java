package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.db.Storage;
import core.basesyntax.exception.FruitShopOperationException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    private FruitShopDao fruitShopDao;

    public SupplyOperationHandler(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        if (fruitTransaction == null) {
            throw new FruitShopOperationException("Can't do a operation, because our model is "
                    + "empty!");
        }
        int amount = Storage.fruits.get(fruitTransaction.getFruit());
        int result = amount + fruitTransaction.getQuantity();
        fruitShopDao.add(fruitTransaction.getFruit(), result);
    }
}
