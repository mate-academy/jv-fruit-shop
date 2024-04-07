package service.impl;

import dao.TransactionDao;
import db.Storage;
import model.FruitTransaction;
import service.ParseService;
import service.TransactionProcessorService;
import strategy.OperationStrategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionProcessorServiceImpl implements TransactionProcessorService {
    private TransactionDao transactionDao;
    private ParseService parseService = new ParseServiceImpl();

    private final Map<FruitTransaction.Operation, OperationStrategy> strategies;

    public TransactionProcessorServiceImpl(Map<FruitTransaction.Operation, OperationStrategy> strategies) {
        this.strategies = strategies;
    }


    @Override
    public Map<String, Integer> processTransaction(List<FruitTransaction> transactions) {
        Map<String, Integer> fruitCounts = new HashMap<>();

        for (FruitTransaction transaction : transactions) {
                String fruit = transaction.getFruit();
                int quantity = transaction.getQuantity();
                String type = transaction.getType().getCode();

                FruitTransaction.Operation operationType =
                        FruitTransaction.Operation.fromCode(type);
                OperationStrategy strategy = strategies.get(operationType);
                if (strategy != null) {
                    strategy.apply(Arrays.asList(fruit, String.valueOf(quantity)), strategies);
                } else {
                    System.out.println("Invalid operation type: " + operationType);
                }

                if (operationType == FruitTransaction.Operation.PURCHASE) {
                    fruitCounts.put(fruit, fruitCounts.getOrDefault(fruit, 0) - quantity);
                } else {
                    fruitCounts.put(fruit, fruitCounts.getOrDefault(fruit, 0) + quantity);
                }
            }
        return fruitCounts;
    }
}
