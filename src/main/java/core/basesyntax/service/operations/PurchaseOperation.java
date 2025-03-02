package core.basesyntax.service.operations;

import core.basesyntax.db.ShopDao;
import core.basesyntax.db.ShopDaoImpl;
import core.basesyntax.service.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    private final ShopDao shopDao = new ShopDaoImpl();

    @Override
    public void update(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity() * -1;
        shopDao.changeFruitQuantity(fruit, quantity);
    }
}
