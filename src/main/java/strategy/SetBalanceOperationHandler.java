package strategy;

import dao.FruitDao;
import model.FruitTransaction;
import service.OperationHandler;

public class SetBalanceOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public SetBalanceOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void doTransaction(FruitTransaction transaction) {
        fruitDao.add(transaction.getFruit(), transaction.getQuantity());
    }
}
