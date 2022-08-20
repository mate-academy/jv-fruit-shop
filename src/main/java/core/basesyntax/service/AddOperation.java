package core.basesyntax.service;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.model.FruitTransaction;

public class AddOperation implements OperationHandler {
    private final FruitShopDao fruitShopDao;

    public AddOperation(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitShopDao.getAll().merge(
                fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(),
                Integer::sum);
    }
}
