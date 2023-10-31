package core.basesyntax.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public BalanceOperationHandlerImpl(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void perform(FruitTransaction fruitTransaction) {
        fruitTransactionDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
