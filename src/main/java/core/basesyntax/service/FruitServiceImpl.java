package core.basesyntax.service;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyOperations(List<TransactionDto> transactionDtos) {
        for (TransactionDto dto : transactionDtos) {
            Operation operation = dto.getOperation();
            operationStrategyMap.get(operation).apply(dto);
        }
    }

    @Override
    public Map<Fruit, Integer> getFruitReport() {
        return Storage.storage;
    }
}
