package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.Storage;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final Map<OperationType, OperationStrategy> operationStrategyMap;

    public FruitShopServiceImpl(Map<OperationType, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public boolean applySuitableOperation(List<FruitRecordDto> fruitRecordDtos) {
        for (FruitRecordDto dto : fruitRecordDtos) {
            operationStrategyMap.get(dto.getOperationType()).apply(dto);
        }
        return true;
    }

    @Override
    public Map<Fruit, Integer> fruitStorage() {
        return Storage.fruitStorage;
    }
}
