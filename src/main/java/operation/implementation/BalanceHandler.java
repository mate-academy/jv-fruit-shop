package operation.implementation;

import dao.FruitDao;
import model.FruitTransaction;
import operation.OperationHandler;

public class BalanceHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void getHandler(FruitTransaction fruitTransaction) {
        fruitDao.add(fruitTransaction);
    }
}
