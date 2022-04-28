package core.basesyntax.operation;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements Operation {
    @Override
    public Operation proceed(FruitTransaction fruitTransaction) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        if (fruitShopDao.getValue(fruitTransaction) == null) {
            fruitShopDao.save(fruitTransaction);
        }
        fruitTransaction.setQuantity(fruitShopDao.getValue(fruitTransaction)
                + fruitTransaction.getQuantity());
        return null;
    }
}
