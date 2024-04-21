package service.impl;

import static java.util.stream.Collectors.summingInt;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import db.Storage;
import model.FruitTransaction;
import service.FruitTransactionProcessor;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private final OperationStrategy operationStrategy = new OperationStrategy();
    private final FruitBalanceCheckService
            fruitBalanceCheckService = new FruitBalanceCheckService();

    @Override
    public void process(List<FruitTransaction> fruitTransactionsList) {
        Map<String, Integer> fruitTransactionsBalance = fruitTransactionsList.stream()
                .collect(Collectors.groupingBy(
                        FruitTransaction::getFruit, summingInt(
                                fruitTransaction -> operationStrategy.getOperation(
                                        fruitTransaction.getQuantity(),
                                        fruitTransaction.getOperation()))));
        Storage.STORAGE.putAll(
                fruitBalanceCheckService.checkNegativeBalance(fruitTransactionsBalance));
    }
}
