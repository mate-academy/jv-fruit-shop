package core.basesyntax.handlers;

import core.basesyntax.db.FruitStorage;

public class AddFruitQuantity implements OperationHandler {
    public void calculateResult(String fruit, int quantity) {
        if (FruitStorage.storageData.get(fruit) != null) {
            FruitStorage.storageData.put(fruit,
                    FruitStorage.storageData.get(fruit) + quantity);
        } else {
            FruitStorage.storageData.put(fruit, quantity);
        }
    }
}

