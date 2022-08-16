package core.basesyntax.strategy.operations;

import core.basesyntax.dao.FruitsDao;

public class SupplyOperation implements OperationHandler {
    private FruitsDao fruitsDao;

    public SupplyOperation(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void handle(String fruitName, int quantity) {
        fruitsDao.add(fruitName, fruitsDao.getFruitQuantity(fruitName) + quantity);
    }
}
