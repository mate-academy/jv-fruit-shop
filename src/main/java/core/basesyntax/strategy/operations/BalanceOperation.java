package core.basesyntax.strategy.operations;

import core.basesyntax.dao.FruitsDao;

public class BalanceOperation implements OperationHandler {
    private FruitsDao fruitsDao;

    public BalanceOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        fruitsDao.add(fruitName, quantity);
    }
}
