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
    Map<Operation, OperationStrategy> operationOperationStrategyMap;
    Storage storage = new Storage();

    public FruitServiceImpl(Map<Operation, OperationStrategy> operationOperationStrategyMap) {
        this.operationOperationStrategyMap = operationOperationStrategyMap;
    }

    @Override
    public void applyOperationsOnFruitsDto(List<TransactionDto> transactionDtos) {
        for (TransactionDto transactionDto: transactionDtos) {
            operationOperationStrategyMap.get(transactionDto.getOperation())
                    .apply(transactionDto, storage);
        }
    }

    @Override
    public Map<Fruit, Integer> getFruitReport() {
        return Storage.fruits;
    }
}
