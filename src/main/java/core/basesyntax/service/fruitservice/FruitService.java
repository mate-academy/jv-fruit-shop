package core.basesyntax.service.fruitservice;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.strategy.OperationStrategy;

import java.util.List;
import java.util.Map;

public interface FruitService {
    void safe(List<FruitRecordDto> fruitRecords, OperationStrategy operationStrategy);
}
