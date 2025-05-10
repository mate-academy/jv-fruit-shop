package strategy;

import java.util.Map;

public interface OperationStrategy {
    void apply(Map<String, Integer> fruitCounts, String fruit, int quantity);
}
