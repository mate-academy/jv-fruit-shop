package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitShopServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyOperationOnFruitsDto(List<TransactionDto> transactionDtos) {
        for (TransactionDto dto : transactionDtos) {
            Operation operation = dto.getOperation();
            operationStrategyMap.get(operation).operate(dto);
        }
    }
}
