package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.stratege.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void selectOperation(List<TransactionDto> transactionDto) {
        if (transactionDto == null) {
            throw new RuntimeException("transactionDto can't be null");
        }
        for (TransactionDto dto : transactionDto) {
            operationStrategyMap.get(dto.getOperation()).doOperation(dto);
        }
    }
}
