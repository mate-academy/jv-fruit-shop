package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Storage;
import core.basesyntax.model.dto.TransactionDto;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitShopServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyOperationoOnFruitsDto(List<TransactionDto> transactionDtos) {
        for (TransactionDto dto : transactionDtos) {
            Operation operation = dto.getOperation();
            operationStrategyMap.get(operation).apply(dto);
        }
    }

    @Override
    public Map<Fruit, Integer> getFruitsReport() {
        return Storage.fruits;
    }
}
