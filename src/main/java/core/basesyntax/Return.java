package core.basesyntax;

import java.util.Map;

public class Return implements OperationStrategy {
    @Override
    public void execute(Map<String, Integer> inventory, String fruit, int quantity) {
        inventory.put(fruit, inventory.getOrDefault(fruit, 0) + quantity); // Возврат фрукта
    }
}
