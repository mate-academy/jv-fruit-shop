package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.fruit.Transaction;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(Transaction transaction) {
        fruitDao.put(transaction.getProduct(),transaction.getQuantity());
    }
}
