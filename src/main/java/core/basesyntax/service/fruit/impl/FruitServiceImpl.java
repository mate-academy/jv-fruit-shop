package core.basesyntax.service.fruit.impl;

import core.basesyntax.model.fruit.Record;
import core.basesyntax.service.fruit.FruitService;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategy strategy;

    public FruitServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Map<String, Integer> processRecords(List<Record> records) {
        for (Record record : records) {
            strategy.get(record.getOperation()).perform(record);
        }
        return Storage.fruitMap;
    }
}
