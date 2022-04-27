package service.impl;

import java.util.List;
import service.FruitService;
import service.FruitTransactionService;
import strategy.OperationStrategy;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final String COMA = ",";
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_QUANTITY = 2;
    private FruitService fruitService;
    private OperationStrategy operationStrategy;

    public FruitTransactionServiceImpl(FruitService fruitService,
                                       OperationStrategy operationStrategy) {
        this.fruitService = fruitService;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transfer(List<String> values) {
        values.stream().filter(e -> !e.startsWith("type"))
                .forEach(e -> {
                    String[] data = e.split(COMA);
                    operationStrategy.get(data[INDEX_OF_OPERATION])
                            .apply(fruitService.createFruit(data[INDEX_OF_FRUIT]),
                                    Integer.parseInt(data[INDEX_OF_QUANTITY]));
                });
    }
}
