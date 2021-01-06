package core.basesyntax.servise.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.servise.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private Map<Operation, OperationStrategy> operationMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public void applyOperation(List<TransactionDto> transactionDtos) {
        for (TransactionDto dto : transactionDtos) {
            OperationStrategy operationStrategy = operationMap.get(dto.getOperation());
            operationStrategy.apply(dto);
        }
    }

    @Override
    public Map<Fruit, Integer> getFruitReport() {
        return Storage.fruits;
    }
}
