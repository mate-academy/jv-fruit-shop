package service.impl;

import fruitscontent.FruitsContent;
import java.util.List;
import service.FruitShopService;
import strategy.OperationStrategy;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy operationStrategy;

    public FruitShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processOfOperations(List<FruitsContent> parsedData) {
        for (FruitsContent line : parsedData) {
            operationStrategy.get(line.getOperation()).handle(line);
        }
    }
}
