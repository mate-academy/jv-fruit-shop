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
    public Map<String, Integer> handleData(List<FruitRecord> fruitRecords) {
        Map<String, Integer> fruitsStorage = new HashMap<>();
        for (FruitRecord fruitRecord : fruitRecords) {
            int handleAmount = operationStrategy.get(fruitRecord.getOperation())
                    .get(fruitRecord, fruitsStorage);
            fruitsStorage.put(fruitRecord.getFruit(), handleAmount);
        }
        return fruitsStorage;
    }
}
