package core.basesyntax.service.operations;

import core.basesyntax.db.ShopDao;
import core.basesyntax.db.ShopDaoImpl;
import core.basesyntax.service.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final ShopDao shopDao = new ShopDaoImpl();

    @Override
    public void update(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        shopDao.addFruit(fruit, quantity);
    }
}
