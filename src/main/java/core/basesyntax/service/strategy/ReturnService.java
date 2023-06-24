package core.basesyntax.service.strategy;

import core.basesyntax.dao.Storage;
import core.basesyntax.exeption.FruitShopExeption;

public class ReturnService extends OperationHandler {

    @Override
    public void moveFruit(String fruit, Integer amount) {
        if (fruit == null || amount == null || amount <= 0) {
            throw new FruitShopExeption("Incorrect input data for adding to storage");
        }
        if (Storage.fruits.containsKey(fruit)) {
            Storage.put(fruit, Storage.get(fruit) + amount);
            return;
        }
        Storage.put(fruit, amount);
    }
}
