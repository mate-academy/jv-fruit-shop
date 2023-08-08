package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String,Integer> fruitBalances = new HashMap<>();

    public Storage() {
        fruitBalances.put("apple",0);
    }

    public void addFruits(String fruit,Integer number) {
        fruitBalances.put(fruit,number);
    }

    public void removeFruit(String fruit, int quantity) {
        int currentQuantity = fruitBalances.getOrDefault(fruit, 0);
        if (currentQuantity > 0) {
            int newQuantity = Math.max(currentQuantity - quantity, 0);
            fruitBalances.put(fruit, newQuantity);
        }
    }

    public int getFruitBalance(String fruit) {
        return fruitBalances.getOrDefault(fruit, 0);
    }

    public Map<String, Integer> getAllFruitBalances() {
        return new HashMap<>(fruitBalances);
    }

    @Override
    public String toString() {
        return "Storage{" + fruitBalances + "}";
    }
}
