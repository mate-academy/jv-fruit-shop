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
    private final Map<Operation, OperationStrategy> operationOperationStrategyMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> operationOperationStrategyMap) {
        this.operationOperationStrategyMap = operationOperationStrategyMap;
    }

    @Override
    public void applyOperation(List<TransactionDto> transaction) {
        for (TransactionDto dto : transaction) {
            Operation operation = dto.getOperation();
            operationOperationStrategyMap.get(operation).apply(dto);
        }
    }

    @Override
    public Map<Fruit, Integer> getFruitReporter() {
        return Storage.getFruits();
    }
}
