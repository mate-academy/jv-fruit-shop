package core.basesyntax.shop.service;

import core.basesyntax.shop.db.Storage;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.model.Operation;
import core.basesyntax.shop.model.TransactionDto;
import core.basesyntax.shop.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private Map<Operation, OperationStrategy> operationStrategyMap;

    public ShopServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyOperationOnFruitsDto(List<TransactionDto> transactionDtos) {
        for (TransactionDto transactionDto : transactionDtos) {
            operationStrategyMap.get(transactionDto.getOperation()).apply(transactionDto);
        }
    }

    @Override
    public Map<Fruit, Integer> getFruitReport() {
        return Storage.fruitBalance;
    }
}
