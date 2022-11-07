package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;

public interface OperationHandler {
    void applyOperation(String fruitName, int value);

    default Integer getBalanceFromFruitName(String fruitName) {
        return Storage.FRUIT_STORAGE.get(fruitName);
    }

    default Integer putNewBalanceToFruit(String fruitName, int newValue) {
        return Storage.FRUIT_STORAGE.put(fruitName, newValue);
    }
}
