package strategy;

import java.util.Map;

public interface OperationStrategy {
    void execute(String fruit, int quantity, Map<String, Integer> fruitQuantities);
}
