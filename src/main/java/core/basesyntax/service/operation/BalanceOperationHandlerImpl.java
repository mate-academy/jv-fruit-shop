package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {

    @Override
    public void operation(FruitTransaction fruitT, FruitTransactionDao fruitTDao) {
        fruitTDao.add(fruitT);
    }
}
