package core.basesyntax.operation;

import core.basesyntax.dao.FruitDao;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doOperation(String fruitName, int quantity) {
        int balanceValue = fruitDao.get(fruitName);
        fruitDao.put(fruitName, balanceValue + quantity);
    }
}
