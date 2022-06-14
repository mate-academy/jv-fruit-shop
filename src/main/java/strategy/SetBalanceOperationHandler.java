package strategy;

import model.FruitTransaction;
import service.FruitDao;
import service.OperationHandler;

public class SetBalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SetBalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        fruitDao.set(transaction.getFruit(), transaction.getQuantity());
    }
}
