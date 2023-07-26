package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public static List<FruitTransaction> getAllFruits() {
        return new ArrayList<>(fruits.values());
    }

    public static void updateFruitQuantity(String fruitName, int quantity) {
        FruitTransaction fruit = fruits.get(fruitName);
        if (fruit != null) {
            fruit.setQuantity(quantity);
        }
    }

    //public static FruitTransaction getFruit(String fruitName) {
    //    Optional<FruitTransaction> optional = Optional.ofNullable(fruits.get(fruitName));
    //    return optional.orElseThrow(() -> new RuntimeException("fruit not exist in DB"));
    //}

    public static Optional<FruitTransaction> getFruit(String fruitName) {
        return Optional.ofNullable(fruits.get(fruitName));
        //return optional.orElseThrow(() -> new RuntimeException("fruit not exist in DB"));
    }
}
