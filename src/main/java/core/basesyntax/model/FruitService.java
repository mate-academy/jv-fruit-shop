package core.basesyntax.model;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.strategy.FruitOperationHandler;
import java.util.List;
import java.util.Map;

public interface FruitService {
    void save(List<FruitRecordDto> recordDtos, Map<Operation,
            FruitOperationHandler> operationStrategyMap);

    String getReport();
}
