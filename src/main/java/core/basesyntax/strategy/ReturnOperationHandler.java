package core.basesyntax.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void pushToStorage(FruitTransaction transaction) {
        fruitDao.add(transaction.getFruitName(), transaction.getQuantity(), Integer::sum);
    }
}
