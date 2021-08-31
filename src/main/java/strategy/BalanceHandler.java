package strategy;

import database.StorageFruits;
import shop.FruitShopOperation;

public class BalanceHandler implements TypeHandler {

    @Override
    public int countAmount(FruitShopOperation fruitShopOperation) {
        StorageFruits.storageFruits.put(fruitShopOperation.getFruit(),
                fruitShopOperation.getAmount());
        return fruitShopOperation.getAmount();
    }
}

