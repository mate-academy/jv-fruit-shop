package strategy;

import db.FruitShopDao;
import model.FruitTransaction;

public class SupplyOperationHandler implements OperationHandler {
    private FruitShopDao fruitShopDao;

    public SupplyOperationHandler(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int newQuantity = fruitShopDao.getFruitQuantity(fruit) + transaction.getQuantity();
        fruitShopDao.put(fruit, newQuantity);
    }
}
