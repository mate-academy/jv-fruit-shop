package core.basesyntax.strategy;

import core.basesyntax.storage.FruitStorage;

public class ShopBalance implements ShopStrategy{

    @Override
    public void editFruitStorageData(FruitStorage fruitStorage, String fruit, Integer quantity) {
        fruitStorage.addData(fruit, quantity);
    }
}
