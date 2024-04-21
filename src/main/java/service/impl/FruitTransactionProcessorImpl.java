package service.impl;

import static java.util.stream.Collectors.summingInt;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitTransactionProcessor;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private final OperationStrategy operationStrategy = new OperationStrategy();

    @Override
    public Map<String, Integer> process(List<FruitTransaction> fruitTransactionsList) {
        return fruitTransactionsList.stream()
                .collect(Collectors.groupingBy(
                        FruitTransaction::getFruit, summingInt(
                                fruitTransaction -> operationStrategy.getOperation(
                                        fruitTransaction.getQuantity(),
                                        fruitTransaction.getOperation()))));
    }
}
