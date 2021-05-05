package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.ApplierFruitsToStorage;
import core.basesyntax.service.SaverDataToStorage;
import java.util.List;
import java.util.Map;

public class SaverDataToStorageImpl implements SaverDataToStorage {
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    public void saveDataToStorage(List<FruitRecordDto> fruitDtos,
                                  Map<OperationType, ApplierFruitsToStorage> operationStrategyMap) {
        for (FruitRecordDto fruitRecordDto : fruitDtos) {
            operationStrategyMap.get(fruitRecordDto.getOperationType())
                    .applyFruitToStorage(fruitRecordDto);
        }
    }
}
