package core.basesyntax;

import java.util.Map;

public class Purchase implements OperationStrategy {
    @Override
    public void execute(Map<String, Integer> inventory, String fruit, int quantity) {
        int currentQuantity = inventory.getOrDefault(fruit, 0);
        if (currentQuantity >= quantity) {
            inventory.put(fruit, currentQuantity - quantity); // Покупка фрукта
        } else {
            throw new RuntimeException("Недостаточно товара для покупки: " + fruit);
        }
    }
}