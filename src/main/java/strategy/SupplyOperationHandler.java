package strategy;

import db.FruitShopDao;

public class SupplyOperationHandler implements OperationHandler {
    private FruitShopDao fruitShopDao;

    public SupplyOperationHandler(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }
    @Override
    public int handleOperation(String fruit, int quantity) {
        int oldQuantity = fruitShopDao.getFruitQuantity(fruit);
        return oldQuantity + quantity;
    }
}
