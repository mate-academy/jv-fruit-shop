package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.fruit.Transaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public PurchaseOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(Transaction transaction) {
        int stored = fruitDao.getByName(transaction.getProduct());
        if (stored - transaction.getQuantity() < 0) {
            throw new RuntimeException("Not fruit: " + transaction.getProduct());
        }
        fruitDao.put(transaction.getProduct(), stored - transaction.getQuantity());
    }
}
