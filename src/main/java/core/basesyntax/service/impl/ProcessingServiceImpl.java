package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ProcessingService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProcessingServiceImpl implements ProcessingService {
    private OperationStrategy operationStrategy;

    public ProcessingServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> processStatistics(List<Fruit> fruits) {
        return fruits.stream()
                .collect(Collectors.groupingBy(Fruit::getFruitName,
                        Collectors.summingInt(fruit ->
                                operationStrategy.get(fruit.getFruitOpCode())
                                .calculate(fruit))));
    }
}
