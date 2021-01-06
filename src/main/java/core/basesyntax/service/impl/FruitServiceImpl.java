package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> operationOperationStrategyMap) {
        this.operationStrategyMap = operationOperationStrategyMap;
    }

    @Override
    public void applyOperationsOnFruitsDto(List<TransactionDto> transactionDtos) {
        for (TransactionDto dto: transactionDtos) {
            Operation operation = dto.getOperation();
            operationStrategyMap.get(operation).apply(dto);
        }
    }

    @Override
    public Map<Fruit, Integer> getFruitReport() {
        return Storage.fruitsMap;
    }
}
