package service.impl;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataProcessor;
import strategy.OperationStrategy;

public class DataProcessorImpl implements DataProcessor {
    private final OperationStrategy operationStrategy;

    public DataProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> fruitTransactions) {
        return fruitTransactions.stream()
                .map(fruitTransaction -> operationStrategy.get(fruitTransaction.getOperation()
                                .getOperation()).getOperationResult(fruitTransaction))
                .collect(groupingBy(FruitTransaction::getFruit,
                        mapping(FruitTransaction::getQuantity,
                                reducing(0, Integer::sum))));
    }
}
