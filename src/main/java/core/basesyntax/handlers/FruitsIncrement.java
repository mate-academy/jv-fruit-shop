package core.basesyntax.handlers;

import core.basesyntax.services.FruitsService;
import core.basesyntax.storage.FruitDataBase;

public class FruitsIncrement implements FruitsService {
    @Override
    public void change(String fruit, Integer amount, FruitDataBase fruitDataBase) {
        Integer oldFruitAmount = fruitDataBase.getFruitShopData(fruit);
        fruitDataBase.setFruitShopData(fruit, oldFruitAmount + amount);
    }
}
