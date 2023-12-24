package core.basesyntax.handlers;

import core.basesyntax.db.FruitStorage;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void calculateResult(String fruit, int quantity) {
        FruitStorage.storageData.put(fruit, FruitStorage.storageData.get(fruit) - quantity);
    }
}
