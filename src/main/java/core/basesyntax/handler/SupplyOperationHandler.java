package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.fruit.Transaction;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void execute(Transaction transaction) {
        int fruit = fruitDao.getByName(transaction.getProduct());
        fruitDao.put(transaction.getProduct(), fruit + transaction.getQuantity());

    }
}
