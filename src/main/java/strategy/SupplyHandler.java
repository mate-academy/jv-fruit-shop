package strategy;

import database.StorageFruits;
import shop.Fruit;
import shop.FruitShopOperation;

public class SupplyHandler implements TypeHandler {
    private int balance;

    @Override
    public void countAmount(FruitShopOperation fruitShopOperation) {
        balance = fruitShopOperation.getAmount();
        StorageFruits.storageFruits.put(new Fruit(fruitShopOperation.getName()), balance);
    }
}
