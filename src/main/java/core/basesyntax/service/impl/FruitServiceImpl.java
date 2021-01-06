package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Record;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyOperationOnRecord(List<Record> records) {
        for (Record record : records) {
            operationStrategyMap.get(record.getOperation()).apply(record);
        }
    }

    @Override
    public Map<String, Long> getFruitReport() {
        return Storage.getStorage()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().getType(), Map.Entry::getValue));
    }
}
