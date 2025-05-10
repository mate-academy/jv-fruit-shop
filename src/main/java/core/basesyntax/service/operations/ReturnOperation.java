package core.basesyntax.service.operations;

import core.basesyntax.db.ShopDao;
import core.basesyntax.db.ShopDaoImpl;
import core.basesyntax.service.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    private final ShopDao shopDao = new ShopDaoImpl();

    @Override
    public void processTransaction(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantity = fruitTransaction.getQuantity();
        shopDao.updateFruitQuantity(fruit, quantity);
    }
}
