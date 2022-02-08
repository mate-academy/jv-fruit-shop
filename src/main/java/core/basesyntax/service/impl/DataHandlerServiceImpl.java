package core.basesyntax.service.impl;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.service.DataHandlerService;
import core.basesyntax.service.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataHandlerServiceImpl implements DataHandlerService {
    private final OperationStrategy operationStrategy;

    public DataHandlerServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> handleData(List<FruitRecord> records) {
        Map<String, Integer> storage = new HashMap<>();
        records.forEach(r -> {
            int handleAmount = operationStrategy.get(r.getOperation()).get(r, storage);
            storage.put(r.getFruit(), handleAmount);
        });
        return storage;
    }
}
