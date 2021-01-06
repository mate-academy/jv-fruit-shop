package core.basesyntax.strategy;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Record;

import java.util.Map;
import java.util.NoSuchElementException;

public class ReductionStrategy implements OperationStrategy {
    @Override
    public void apply(Record record) {
        Map<Fruit, Long> storage = Storage.getStorage();
        Fruit fruit = record.getFruit();
        long amount = record.getAmount();
        if (storage.containsKey(fruit)) {
            if (storage.get(fruit) - amount < 0) {
                throw new IllegalArgumentException("Count of fruits can't be less than 0");
            }
            storage.put(fruit, (storage.get(fruit) - amount));
        } else {
            throw new NoSuchElementException(fruit.getType() + " not found in storage");
        }
    }
}
