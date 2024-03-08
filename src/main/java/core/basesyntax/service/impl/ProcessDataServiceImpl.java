package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.factory.Factory;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.strategy.Strategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessDataServiceImpl implements ProcessDataService {
    @Override
    public void processData(List<Fruit> convert, Factory factory) {
        Map<String, Integer> storage = new HashMap<>();
        for (Fruit fruit : convert) {
            int totalAmount = 0;
            for (Map.Entry<Operation, Integer> operation : fruit.operation().entrySet()) {
                Operation operationType = operation.getKey();
                Strategy strategy = factory.getStrategy(operationType);
                int amount = operation.getValue();
                totalAmount += strategy.calculation(amount);
            }
            if (totalAmount < 0) {
                throw new RuntimeException("totalAmount can not be negative");
            }
            storage.put(fruit.name(), totalAmount);
        }
        Storage.addElements(storage);
    }
}
