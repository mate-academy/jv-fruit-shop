package service.Implementation;

import model.FruitTransactionDto;
import model.Operation;
import service.FruitShopService;
import strategy.OperationStrategy;

import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitShopServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyOperationsOnFruitsDto(List<FruitTransactionDto> fruitTransactionDtoList) {
        for (FruitTransactionDto transactionDto : fruitTransactionDtoList) {
            Operation operation = transactionDto.getOperation();
            operationStrategyMap.get(operation).apply(transactionDto);
        }
    }
}
