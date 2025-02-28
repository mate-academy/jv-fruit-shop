package service.impl;

import db.Storage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.Operation;
import service.OperationHandler;
import strategy.OperationStrategy;

public class BalanceCalculatorImpl implements Operation {
    private final OperationStrategy strategy;

    public BalanceCalculatorImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Map<String, Integer> update(List<FruitTransaction> data) {
        for (FruitTransaction fruit : data) {
            String fruitName = fruit.getFruit();
            int quantity = fruit.getQuantity();
            OperationHandler operationService = strategy.getOperationService(fruit.getOperation());
            int updatedBalance = operationService
                    .operate(quantity, Storage.fruitsStorage.getOrDefault(fruitName, 0));
            Storage.fruitsStorage.put(fruitName, updatedBalance);
        }
        return Storage.fruitsStorage;
    }
}
