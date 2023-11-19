package strategy;

import db.FruitShopDao;

public class PurchaseOperationHandler implements OperationHandler {
    private FruitShopDao fruitShopDao;

    public PurchaseOperationHandler(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }
    @Override
    public int handleOperation(String fruit, int quantity) {
        int oldQuantity = fruitShopDao.getFruitQuantity(fruit);
        int newQuantity = oldQuantity - quantity;
        if (newQuantity < 0) {
            throw new RuntimeException("Balance can't be negative!");
        }
        return newQuantity;
    }
}
