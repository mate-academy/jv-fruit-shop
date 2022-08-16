package core.basesyntax.strategy.operations;

import core.basesyntax.dao.FruitsDao;

public class ReturnOperation implements OperationHandler {
    private FruitsDao fruitsDao;

    public ReturnOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        fruitsDao.add(fruitName, fruitsDao.getFruitQuantity(fruitName) + quantity);
    }
}
