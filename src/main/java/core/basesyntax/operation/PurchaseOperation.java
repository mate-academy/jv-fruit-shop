package core.basesyntax.operation;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        if (fruitShopDao.getStorage().containsKey(fruitTransaction.getFruit())
                && fruitShopDao
                .getAmount(fruitTransaction.getFruit()) >= fruitTransaction.getQuantity()) {
            fruitShopDao.add(fruitTransaction.getFruit(),
                    fruitShopDao.getAmount(fruitTransaction.getFruit())
                            - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Can`t sell this Fruit!");
        }
    }
}
