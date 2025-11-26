package core.basesyntax.strategy.operation;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private FruitsDao fruitsDao;

    public BalanceOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void transaction(FruitTransaction fruitTransaction) {
        fruitsDao.add(fruitTransaction);
    }
}
