package service.implementation;

import db.FruitStorage;
import exception.InvalidDataFormatException;
import java.util.List;
import java.util.Map;
import model.Fruit;
import model.FruitTransactionDto;
import model.Operation;
import service.FruitShopService;
import strategy.OperationStrategy;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String EXCEPTION_MESSAGE = "Your data has invalid format,"
            + " something is missing" + "\n";

    private final Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitShopServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyOperationsOnFruitsDto(List<FruitTransactionDto> fruitTransactionDtoList) {
        for (FruitTransactionDto transactionDto : fruitTransactionDtoList) {
            try {
                Operation operation = transactionDto.getOperation();
                operationStrategyMap.get(operation).apply(transactionDto);
            } catch (RuntimeException e) {
                throw new InvalidDataFormatException(EXCEPTION_MESSAGE + e);
            }
        }
    }

    @Override
    public Map<Fruit, Integer> getFruitReport() {
        return FruitStorage.getFruitStorage();
    }

}
