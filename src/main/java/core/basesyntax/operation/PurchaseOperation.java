package core.basesyntax.operation;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements Operation {
    @Override
    public Operation proceed(FruitTransaction fruitTransaction) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        fruitTransaction.setQuantity(fruitShopDao.getValue(fruitTransaction)
                - fruitTransaction.getQuantity());
        fruitShopDao.save(fruitTransaction);
        return null;
    }
}
