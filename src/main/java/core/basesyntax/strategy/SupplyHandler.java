package core.basesyntax.strategy;

import core.basesyntax.storage.FruitStorage;

public class SupplyHandler implements OperationHandler {
    @Override
    public void editFruitStorageData(FruitStorage fruitStorage, String fruit, Integer quantity) {
        if (fruitStorage.getStorage().get(fruit) < quantity) {
            throw new RuntimeException("Can't supply fruit: "
                    + fruit
                    + " balance less than "
                    + quantity);
        }
        fruitStorage.addQuantity(fruit, quantity);
    }
}
