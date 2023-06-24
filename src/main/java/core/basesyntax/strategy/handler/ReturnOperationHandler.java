package core.basesyntax.strategy.handler;

import core.basesyntax.db.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        int fruitsBefore = FruitDao.getAll().get(transaction.getFruit());
        int fruitsToStorage = transaction.getQuantity();
        if (fruitsToStorage < 0) {
            throw new RuntimeException("Returned fruits quantity must be positive value");
        } else {
            FruitDao.getAll()
                    .put(transaction.getFruit(), fruitsBefore + fruitsToStorage);
        }
    }
}
