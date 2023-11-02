package core.basesyntax.operation;

import core.basesyntax.dao.FruitQuantityDao;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperationHandlerImpl implements OperationHandler {
    private final FruitQuantityDao fruitQuantityDao;

    public SupplyOperationHandlerImpl(FruitQuantityDao fruitQuantityDao) {
        this.fruitQuantityDao = fruitQuantityDao;
    }

    @Override
    public void perform(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int currentQuantity = fruitQuantityDao.get(fruit);
        fruitQuantityDao.add(fruit, currentQuantity + fruitTransaction.getQuantity());
    }
}
