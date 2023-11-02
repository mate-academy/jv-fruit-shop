package core.basesyntax.operation;

import core.basesyntax.dao.FruitQuantityDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private final FruitQuantityDao fruitQuantityDao;

    public BalanceOperationHandlerImpl(FruitQuantityDao fruitQuantityDao) {
        this.fruitQuantityDao = fruitQuantityDao;
    }

    @Override
    public void perform(FruitTransaction fruitTransaction) {
        fruitQuantityDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
