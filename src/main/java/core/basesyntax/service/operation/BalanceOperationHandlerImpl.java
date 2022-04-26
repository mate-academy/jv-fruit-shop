package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        fruitTransactionDao.add(fruitTransaction);
    }
}
