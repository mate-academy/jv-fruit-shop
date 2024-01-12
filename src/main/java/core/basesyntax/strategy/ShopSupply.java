package core.basesyntax.strategy;

import core.basesyntax.storage.FruitStorage;

public class ShopSupply implements ShopStrategy{
    @Override
    public void editFruitStorageData(FruitStorage fruitStorage, String fruit, Integer quantity) {
        fruitStorage.addQuantity(fruit, quantity);
    }
}
