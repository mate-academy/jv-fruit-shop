package core.basesyntax.operation;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        if (fruitShopDao.getStorage().containsKey(fruitTransaction.getFruit())) {
            fruitShopDao.add(fruitTransaction.getFruit(),
                    fruitShopDao.getAmount(fruitTransaction.getFruit())
                            + fruitTransaction.getQuantity());
        } else {
            fruitShopDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
