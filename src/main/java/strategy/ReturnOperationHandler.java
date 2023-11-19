package strategy;

import db.FruitShopDao;

public class ReturnOperationHandler implements OperationHandler {
    private FruitShopDao fruitShopDao;

    public ReturnOperationHandler(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public int handleOperation(String fruit, int quantity) {
        int oldQuantity = fruitShopDao.getFruitQuantity(fruit);
        return oldQuantity + quantity;
    }
}
