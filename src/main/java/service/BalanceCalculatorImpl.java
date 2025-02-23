package service;

import core.basesyntax.FruitTransaction;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BalanceCalculatorImpl implements OperationHandler {
    @Override
    public Map<String, Integer> update(List<FruitTransaction> data) {
        Set<String> fruitsSet = new HashSet<>();
        for (FruitTransaction fruit : data) {
            fruitsSet.add(fruit.getFruit());
        }
        Map<String, Integer> fruitsMap = new HashMap<>();
        OperationStrategy strategy = new OperationStrategy();
        for (String fruitFromSet : fruitsSet) {
            int balance = 0;
            for (FruitTransaction fruit : data) {
                if (fruit.getFruit().equals(fruitFromSet)) {
                    OperationService operationService = strategy
                            .getOperationService(fruit.getOperation());
                    balance = operationService.operate(fruit.getQuantity(), balance);
                }
            }
            if (balance < 0) {
                throw new RuntimeException("Balance is less than 0, please check your file");
            }
            fruitsMap.put(fruitFromSet, balance);
        }
        return fruitsMap;
    }
}
