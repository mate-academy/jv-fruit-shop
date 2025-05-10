package core.basesyntax.service.operation;

import core.basesyntax.checker.Validator;
import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final FruitTransactionDao fruitTransactionDao;

    public BalanceOperation(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public void recount(FruitTransaction transaction) {
        Validator.checkQuantity(transaction.getQuantity());
        fruitTransactionDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
