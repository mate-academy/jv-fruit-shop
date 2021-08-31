package strategy;

import database.StorageFruits;
import shop.Fruit;
import shop.FruitShopOperation;

public class ReturnHandler implements TypeHandler {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public int countAmount(FruitShopOperation fruitShopOperation) {
        Fruit fruit = fruitShopOperation.getFruit();
        int oldQuantity = StorageFruits.storageFruits.getOrDefault(fruit, DEFAULT_VALUE);
        int newQuantity = oldQuantity + fruitShopOperation.getAmount();
        StorageFruits.storageFruits.put(fruitShopOperation.getFruit(), newQuantity);
        return newQuantity;
    }
}
