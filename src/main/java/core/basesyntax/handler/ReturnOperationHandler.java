package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.fruit.Transaction;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(Transaction transaction) {
        int quantity = fruitDao.getByName(transaction.getProduct()) + transaction.getQuantity();
        fruitDao.put(transaction.getProduct(), quantity);
    }
}
