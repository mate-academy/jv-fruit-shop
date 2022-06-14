package strategy;

import model.FruitTransaction;
import service.FruitDao;
import service.OperationHandler;

public class SubtractOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SubtractOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        fruitDao.subtract(transaction.getFruit(), transaction.getQuantity());
    }
}
