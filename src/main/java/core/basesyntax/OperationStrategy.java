package core.basesyntax;

import java.util.Map;

public interface OperationStrategy {
    void execute(Map<String, Integer> fruitShop, String fruit, int quantity);
}
