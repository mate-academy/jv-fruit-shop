package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<String, Integer> fruits = new HashMap<>();

    public void balance(String fruit, int quantity) {
        // Устанавливает начальный баланс фруктов
        fruits.put(fruit, quantity);
    }

    public void purchase(String fruit, int quantity) {
        // Уменьшаем количество фруктов при покупке
        int currentQuantity = fruits.getOrDefault(fruit, 0);
        if (currentQuantity < quantity) {
            throw new IllegalStateException("Not enough " + fruit + " in storage");
        }
        fruits.put(fruit, currentQuantity - quantity);
    }

    public void returnFruit(String fruit, int quantity) {
        // Увеличиваем количество фруктов при возврате
        int currentQuantity = fruits.getOrDefault(fruit, 0);
        fruits.put(fruit, currentQuantity + quantity);
    }

    public void supply(String fruit, int quantity) {
        // Добавляем фрукты при поставке
        int currentQuantity = fruits.getOrDefault(fruit, 0);
        fruits.put(fruit, currentQuantity + quantity);
    }

    public Map<String, Integer> getFruits() {
        return new HashMap<>(fruits);
    }
}
