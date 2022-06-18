
package core.basesyntax.strategy;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.dao.ShopDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    private final ShopDao shopDao = new ShopDaoImpl();

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() > shopDao.getFruits().get(fruitTransaction.getFruit())) {
            throw new RuntimeException("There is not such amount of "
                    + fruitTransaction.getFruit());
        }
        shopDao.add(fruitTransaction.getFruit(),
                shopDao.getFruits().get(fruitTransaction.getFruit())
                        - fruitTransaction.getQuantity());
    }
}
