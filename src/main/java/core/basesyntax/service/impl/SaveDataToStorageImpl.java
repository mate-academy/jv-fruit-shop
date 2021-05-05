package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperation;
import core.basesyntax.service.SaveDataToStorage;
import core.basesyntax.service.operations.OperationType;
import java.util.List;
import java.util.Map;

public class SaveDataToStorageImpl implements SaveDataToStorage {
    @Override
    public void saveData(List<FruitRecordDto> recordDtos,
                         Map<String, FruitOperation> operationMap) {
        for (FruitRecordDto fruitRecordDto : recordDtos) {
            OperationType operationType = fruitRecordDto.getOperationType();
            FruitOperation fruitOperation = operationMap.get(operationType.getOperation());
            fruitOperation.apply(fruitRecordDto);
        }
    }
}
