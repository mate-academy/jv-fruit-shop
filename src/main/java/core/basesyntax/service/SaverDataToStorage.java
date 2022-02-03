package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.impl.OperationType;
import java.util.List;
import java.util.Map;

public interface SaverDataToStorage {
    void saveDataToStorage(List<FruitRecordDto> fruitDtos,
                                  Map<OperationType, ApplierFruitsToStorage> operationStrategyMap);
}
