package service.impl;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.TransactionProcessor;
import strategy.OperationStrategy;

public class TransactionProcessorImpl implements TransactionProcessor {
    private final OperationStrategy operationStrategy;

    public TransactionProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> fruitTransactions) {
        return fruitTransactions.stream()
                .map(fruitTransaction -> operationStrategy.get(fruitTransaction.getOperation())
                        .getOperationResult(fruitTransaction))
                .collect(groupingBy(FruitTransaction::getFruit,
                        summingInt(FruitTransaction::getQuantity)));
    }
}
