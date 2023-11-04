package core.basesyntax.operation;

import core.basesyntax.dao.FruitDao;

public class SupplyOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SupplyOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doOperation(String fruitName, int quantity) {
        int balanceValue = fruitDao.get(fruitName);
        fruitDao.put(fruitName, balanceValue + quantity);
    }
}
