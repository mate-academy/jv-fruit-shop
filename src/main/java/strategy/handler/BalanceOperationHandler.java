package strategy.handler;

import dao.FruitsDao;
import model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    private FruitsDao fruitsDao;

    public BalanceOperationHandler(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void add(FruitTransaction fruitTransaction) {
        fruitsDao.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
