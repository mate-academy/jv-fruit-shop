package core.basesyntax.strategy;

import core.basesyntax.model.dto.FruitDto;
import core.basesyntax.service.StorageService;
import java.util.Map;

public class TransDistrStrategyImpl implements TransDistrStrategy {
    private final Map<String, StorageService> operationMap;

    public TransDistrStrategyImpl(Map<String, StorageService> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public StorageService choseStorageService(FruitDto fruitDto) {
        return operationMap.get(fruitDto.getTypeOfOperation());
    }
}
