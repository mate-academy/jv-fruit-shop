package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.ApplierFruitsToStorage;
import core.basesyntax.service.SaverDataToStorage;
import java.util.List;
import java.util.Map;

public class SaverDataToStorageImpl implements SaverDataToStorage {

    public void saveDataToStorage(List<FruitRecordDto> fruitDtos,
                                  Map<OperationType, ApplierFruitsToStorage> operationStrategyMap) {
        for (FruitRecordDto fruitRecordDto : fruitDtos) {
            operationStrategyMap.get(fruitRecordDto.getOperationType())
                    .applyFruitToStorage(fruitRecordDto);
        }
    }
}
