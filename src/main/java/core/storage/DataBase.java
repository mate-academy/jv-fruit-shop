package core.storage;

import core.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public static final Map<Fruit, Integer> stock = new HashMap<>();

    public void add(Fruit fruit, Integer quantity) {
        stock.put(fruit, quantity);
    }

    public void append(Fruit fruit, Integer quantity) {
        if (stock.containsKey(fruit)) {
            stock.put(fruit, stock.get(fruit) + quantity);
        }
    }

    public void remove(Fruit fruit, Integer quantity) {
        if (!stock.containsKey(fruit)) {
            throw new RuntimeException(fruit + "s are out of stock");
        }
        if (stock.get(fruit) < quantity) {
            throw new RuntimeException("There is not enough fruit in stock!");
        }
        stock.put(fruit, stock.get(fruit) - quantity);
    }
}
