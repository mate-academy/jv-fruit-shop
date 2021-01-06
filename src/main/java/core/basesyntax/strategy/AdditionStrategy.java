package core.basesyntax.strategy;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Record;
import java.util.Map;

public class AdditionStrategy implements OperationStrategy {
    @Override
    public void apply(Record record) {
        Map<Fruit, Long> storage = Storage.getStorage();
        Fruit fruit = record.getFruit();
        long amount = record.getAmount();
        if (storage.containsKey(fruit)) {
            storage.put(fruit, (storage.get(fruit) + amount));
        } else {
            storage.put(fruit, amount);
        }
    }
}
