package core.basesyntax.service.fruitservice;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    @Override
    public void safe(List<FruitRecordDto> fruitRecords, OperationStrategy operationStrategy) {
        Map<Fruit, Integer> fruitStorage = Storage.fruitStorage;
        for (FruitRecordDto record : fruitRecords) {
            fruitStorage.put(record.getFruitName(),
                    operationStrategy.get(record.getOperationType().getType())
                            .getAmount(record));
        }
    }
}
