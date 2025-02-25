package service.impl;

import db.Storage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.Operation;
import service.OperationHandler;
import strategy.OperationStrategy;

public class BalanceCalculatorImpl implements Operation {
    @Override
    public Map<String, Integer> update(List<FruitTransaction> data) {
        OperationStrategy strategy = new OperationStrategy();
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
