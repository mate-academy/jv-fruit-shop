package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStorage {
    private static Map<String, FruitTransaction> fruits;

    public FruitStorage() {
        this.fruits = new HashMap<>();
    }

    public static Map<String, FruitTransaction> getFruits() {
        return fruits;
    }

    public static void addFruit(FruitTransaction fruit) {
        fruits.put(fruit.getName(), fruit);
    }

    public List<FruitTransaction> getAllFruits() {
        return new ArrayList<>(fruits.values());
    }

    public static void updateFruitQuantity(String fruitName, int quantity) {
        FruitTransaction fruit = fruits.get(fruitName);
        if (fruit != null) {
            fruit.setQuantity(quantity);
        }
    }

    public static FruitTransaction getFruit(String fruitName) {
        return fruits.get(fruitName);
    }
}
