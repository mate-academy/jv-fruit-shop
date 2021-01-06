package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyOperationOnFruitDto(List<TransactionDto> transactionDto) {
        for (TransactionDto transaction : transactionDto) {
            Operation operation = transaction.getOperation();
            operationStrategyMap.get(operation).apply(transaction);
        }
    }

    @Override
    public Map<String, Long> getFruitReport() {
        return Storage.fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getName, Collectors.counting()));
    }
}
