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
    private final Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyOperationsOnFruitsDto(List<TransactionDto> transactionDtos) {
        for (TransactionDto transactionDto : transactionDtos) {
            operationStrategyMap.get(transactionDto.getOperation()).apply(transactionDto);
        }
    }

    @Override
    public Map<Fruit, Integer> getFruitsReport() {
        return Storage.fruitReport;
    }
}
