package core.basesyntax.handlers;

import core.basesyntax.db.FruitStorage;

public class QuantityAdditionHandler implements OperationHandler {
    public void calculateResult(String fruit, int quantity) {
        FruitStorage.storageData.merge(fruit, quantity, Integer::sum);
    }
}
