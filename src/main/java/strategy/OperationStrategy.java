package strategy;

import model.FruitTransaction;

import java.util.List;
import java.util.Map;

public interface OperationStrategy {
    void apply(Map<String, Integer> fruitCounts, String fruit, int quantity);
}
