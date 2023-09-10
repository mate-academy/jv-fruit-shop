package strategy;

import database.StorageFruits;
import shop.Fruit;
import shop.FruitShopOperation;

public class PurchaseHandler implements TypeHandler {
    private static final int DEFAULT_VALUE = 0;

    @Override
    public int countAmount(FruitShopOperation fruitShopOperation) {
        Fruit fruit = fruitShopOperation.getFruit();
        int oldQuantity = StorageFruits.storageFruits.getOrDefault(fruit, DEFAULT_VALUE);
        int newQuantity = oldQuantity - fruitShopOperation.getAmount();
        if (newQuantity <= 0) {
            throw new RuntimeException("not enough " + fruit.getName());
        }
        StorageFruits.storageFruits.put(fruitShopOperation.getFruit(), newQuantity);
        return newQuantity;
    }
}
