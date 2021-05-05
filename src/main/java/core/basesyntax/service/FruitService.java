package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.model.dto.FruitRecordDto;
import java.util.List;
import java.util.Map;

public interface FruitService {
    void addToStorage(List<FruitRecordDto> recordDtos, Map<Operation,
                      FruitOperationHandler> strategyMap);

    String getReport();
}
