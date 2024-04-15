package service.impl;

import static java.util.stream.Collectors.summingInt;

import db.Storage;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitTransactionProcessor;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private final OperationStrategy operationStrategy = new OperationStrategy();

    @Override
    public void process(List<FruitTransaction> fruitTransactionsList) {
        Map<String, Integer> fruitTransactions = fruitTransactionsList.stream()
                .collect(Collectors.groupingBy(
                        FruitTransaction::getFruit, summingInt(fruitTransaction
                                -> operationStrategy
                                .getOperationService(fruitTransaction.getOperation())
                                .operate(fruitTransaction.getQuantity()))));
        Storage.saveToFruitsBalanceReport(fruitTransactions);
    }
}
