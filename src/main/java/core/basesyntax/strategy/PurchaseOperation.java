package core.basesyntax.strategy;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class PurchaseOperation implements OperationStrategy {
    @Override
    public void apply(Fruit fruit, Integer quantity) {
        Integer newValue = Storage.fruits
                .computeIfPresent(fruit, (k, v) -> purchase(v, quantity));
        if (newValue == null) {
            throw new IllegalArgumentException(
                    "Such fruit is not exist in the Storage: " + fruit.getName());
        }
    }

    private Integer purchase(Integer oldValue, Integer subtrahend) {
        if (oldValue < subtrahend) {
            throw new IllegalArgumentException(
                    "There are not enough fruits. Amount: " + oldValue
                            + ", but need " + subtrahend);
        }
        return oldValue - subtrahend;
    }
}
