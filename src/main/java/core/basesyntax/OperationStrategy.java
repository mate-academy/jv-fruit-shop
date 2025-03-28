package core.basesyntax;

import java.util.Map;

public interface OperationStrategy {
    void execute(Map<String, Integer> inventory, String fruit, int quantity);
}