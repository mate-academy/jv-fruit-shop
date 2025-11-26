package core.basesyntax.strategy.operation;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    private FruitsDao fruitsDao;

    public ReturnOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        Integer i = fruitsDao.get(fruitTransaction.getName());

        int quantity = i + fruitTransaction.getQuantity();

        fruitsDao.set(fruitTransaction.getName(), quantity);
    }
}
