package strategy;

import db.FruitShopDao;
import model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitShopDao fruitShopDao;

    public PurchaseOperationHandler(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void handleOperation(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        int newQuantity = fruitShopDao.getFruitQuantity(fruit) - transaction.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Balance can't be negative!");
        }
        fruitShopDao.put(fruit, newQuantity);
    }
}
