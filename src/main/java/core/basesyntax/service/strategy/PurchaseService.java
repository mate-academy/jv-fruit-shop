package core.basesyntax.service.strategy;

import core.basesyntax.dao.Storage;
import core.basesyntax.exeption.FruitShopExeption;

public class PurchaseService extends OperationHandler {

    @Override
    public void moveFruit(String fruit, Integer amount) {
        if (fruit == null || amount == null) {
            throw new FruitShopExeption("Incorrect input data for removing from storage");
        }
        if (!Storage.fruits.containsKey(fruit) || Storage.get(fruit) < amount) {
            throw new FruitShopExeption("You want take away " + amount + " "
                    + fruit + ", but in storage only " + Storage.fruits.get(fruit));
        }
        Storage.put(fruit, Storage.get(fruit) - amount);
    }
}
