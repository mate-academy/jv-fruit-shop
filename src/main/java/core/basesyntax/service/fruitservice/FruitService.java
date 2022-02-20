package core.basesyntax.service.fruitservice;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public interface FruitService {
    void safe(List<FruitRecordDto> fruitRecords, OperationStrategy operationStrategy);
}
