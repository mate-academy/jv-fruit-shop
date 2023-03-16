package strategy.handler;

import dao.FruitsDao;
import db.Storage;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitsDao fruitsDao;

    public PurchaseOperationHandler(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void add(FruitTransaction fruitTransaction) {
        isValidFruit(fruitTransaction.getFruit());
        int quantityInDataBase = fruitsDao.get(fruitTransaction.getFruit());
        if (fruitTransaction.getQuantity() <= quantityInDataBase) {
            fruitsDao.add(fruitTransaction.getFruit(),
                    quantityInDataBase - fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException("Not enough " + fruitTransaction.getFruit());
        }

    }

    private void isValidFruit(String fruit) {
        if (!Storage.fruits.containsKey(fruit)) {
            throw new RuntimeException("There is no " + fruit + " in the database");
        }
    }
}
