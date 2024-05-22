package core.basesyntax.service;

import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;
    private Map<String, Integer> fruits = new HashMap<>();

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.get(transaction.getOperation()).handle(transaction);
        }
    }

    @Override
    public void addFruits(String fruit, int quantity) {
        fruits.put(fruit,fruits.getOrDefault(fruit,0) + quantity);
    }

    @Override
    public int getQuantity(String fruit) {
        return fruits.getOrDefault(fruit,0);
    }

    @Override
    public Map<String, Integer> getFruits() {
        return fruits;
    }
}
