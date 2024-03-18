package service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private static final int PRIMARY_QUANTITY = 0;
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> processData(List<FruitTransaction> dataFromCsv) {
        return dataFromCsv.stream()
                .collect(Collectors.groupingBy(FruitTransaction::getFruit,
                        Collectors.summingInt(line -> operationStrategy.get(line.getOperation())
                                .executionOfOperation(line.getQuantity(), PRIMARY_QUANTITY))));
    }
}
