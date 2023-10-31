package core.basesyntax.operation;

import core.basesyntax.dao.FruitQuantityDao;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private final FruitQuantityDao fruitQuantityDao;

    public PurchaseOperationHandlerImpl(FruitQuantityDao fruitQuantityDao) {
        this.fruitQuantityDao = fruitQuantityDao;
    }

    @Override
    public void perform(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int currentQuantity = fruitQuantityDao.get(fruit);
        fruitQuantityDao.replace(fruit, currentQuantity - fruitTransaction.getQuantity());
    }
}
