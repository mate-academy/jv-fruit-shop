package core.basesyntax.db;

import core.basesyntax.model.Fruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStorage {
    private Map<String, Fruit> fruits;

    public FruitStorage() {
        this.fruits = new HashMap<>();
    }

    public void addFruit(Fruit fruit) {
        fruits.put(fruit.getName(), fruit);
    }

    public List<Fruit> getAllFruits() {
        return new ArrayList<>(fruits.values());
    }

    public void updateFruitQuantity(String fruitName, int quantity) {
        Fruit fruit = fruits.get(fruitName);
        if (fruit != null) {
            fruit.setQuantity(quantity);
        }
    }

    public Fruit getFruit(String fruitName) {
        return fruits.get(fruitName);
    }
}