package service.impl;

import db.Storage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.TransactionProcessorService;
import strategy.OperationStrategy;

public class TransactionProcessorServiceImpl implements TransactionProcessorService {
    private Map<String, Integer> fruitCounts;

    private final Map<FruitTransaction.Operation, OperationStrategy> strategies;

    public TransactionProcessorServiceImpl(Map<FruitTransaction.Operation,
            OperationStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public Map<String, Integer> processTransaction(List<FruitTransaction> transactions) {
        fruitCounts = Storage.getFruitCounts();

        for (FruitTransaction transaction : transactions) {
            processSingleTransaction(transaction);
        }
        return fruitCounts;
    }

    private void processSingleTransaction(FruitTransaction transaction) {
        FruitTransaction.Operation typeOfOperation = transaction.getType();
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();

        OperationStrategy strategy = strategies.get(typeOfOperation);
        if (strategy != null) {
            strategy.apply(fruitCounts, fruit, quantity);
        } else {
            System.out.println("Invalid operation type: " + typeOfOperation);
        }
    }
}

