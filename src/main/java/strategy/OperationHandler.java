package strategy;

import java.util.Map;
//OperationHandler
public interface OperationHandler {
    void apply(Map<String, Integer> inventory, String fruit, int quantity);
}
