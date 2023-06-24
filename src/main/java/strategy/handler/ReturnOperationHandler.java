package strategy.handler;

import dao.FruitsDao;
import model.FruitTransaction;

public class ReturnOperationHandler implements OperationHandler {
    private FruitsDao fruitsDao;

    public ReturnOperationHandler(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void add(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int amount = fruitsDao.get(fruit);
        amount += fruitTransaction.getQuantity();
        fruitsDao.add(fruit, amount);
    }
}
