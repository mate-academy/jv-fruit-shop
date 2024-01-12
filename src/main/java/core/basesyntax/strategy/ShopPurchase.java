package core.basesyntax.strategy;

import core.basesyntax.storage.FruitStorage;

public class ShopPurchase implements ShopStrategy {
    @Override
    public void editFruitStorageData(FruitStorage fruitStorage, String fruit, Integer quantity) {
        fruitStorage.editQuantity(fruit, quantity);
    }
}
