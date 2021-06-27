package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Storage;
import core.basesyntax.model.dto.FruitRecordDto;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitShopServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyOperationOnFruitsDto(List<FruitRecordDto> transactionDtos) {
        for (FruitRecordDto dto : transactionDtos) {
            Operation operation = dto.getOperation();
            operationStrategyMap.get(operation).apply(dto);
        }
    }

    @Override
    public Map<Fruit, Integer> getFruits() {
        return Storage.fruits;
    }
}
