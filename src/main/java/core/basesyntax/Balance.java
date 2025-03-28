package core.basesyntax;

import java.util.Map;

public class Balance implements OperationStrategy {
    @Override
    public void execute(Map<String, Integer> inventory, String fruit, int quantity) {
        inventory.put(fruit, quantity); // Устанавливаем баланс
    }
}