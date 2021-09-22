package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.operations.OperationHendler;
import core.basesyntax.service.strategy.OperationsStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationsStrategy operationsStrategy;

    public FruitShopServiceImpl(OperationsStrategy operationsStrategy) {
        this.operationsStrategy = operationsStrategy;
    }

    @Override
    public void applyOperationsOnFruitsDto(List<TransactionDto> parsedInfo) {
        for (TransactionDto transactionDto : parsedInfo) {
            OperationHendler operation = operationsStrategy.get(transactionDto.getOperation());
            operation.apply(transactionDto);
        }
    }
}
