package core.basesyntax.operation;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        fruitShopDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
