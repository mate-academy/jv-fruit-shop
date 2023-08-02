package core.basesyntax.strategy;

import core.basesyntax.storage.Storage;

public class PurchaseOperation implements OperationStrategy {
    @Override
    public void apply(String fruit, Integer quantity) {
        Integer newValue = Storage.fruits
                .computeIfPresent(fruit, (k, v) -> subtractFromStorage(v, quantity));
        if (newValue == null) {
            throw new IllegalArgumentException(
                    "Such fruit does not exist in the Storage: " + fruit);
        }
    }

    private Integer subtractFromStorage(Integer oldValue, Integer subtrahend) {
        if (oldValue < subtrahend) {
            throw new IllegalArgumentException(
                    "There aren't enough fruits in the Storage. The amount is " + oldValue
                            + ", but " + subtrahend + " are needed");
        }
        return oldValue - subtrahend;
    }
}
