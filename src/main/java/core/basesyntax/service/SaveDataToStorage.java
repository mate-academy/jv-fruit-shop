package core.basesyntax.service;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.operations.OperationType;
import java.util.List;
import java.util.Map;

public interface SaveDataToStorage {
    void saveData(List<FruitRecordDto> recordDtos, Map<OperationType, FruitOperation> operationMap);
}
