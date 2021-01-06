package core.basesyntax.service.impl;

import core.basesyntax.basesyntaxdb.Storage;
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
    public void applyOperationOnFruitDto(List<TransactionDto> transactionDtos) {
        for (TransactionDto dto : transactionDtos) {
            Operation operation = dto.getOperation();
            operationStrategyMap.get(operation).apply(dto);
        }
    }

    public Map<String, Long> getDefaultReport() {
        return Storage.fruitList.stream()
                .collect(Collectors.groupingBy(Fruit::getName, Collectors.counting()));
    }
}
