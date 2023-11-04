package db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruitsStorage = new HashMap<>();

    public static void addFruits(String fruitName, int fruitsNumber) {
        checkInput(fruitName, fruitsNumber);

        if (!fruitsStorage.containsKey(fruitName)) {
            fruitsStorage.put(fruitName, fruitsNumber);
        } else {
            int newStock = fruitsStorage.get(fruitName) + fruitsNumber;
            fruitsStorage.put(fruitName, newStock);
        }
    }

    public static void subtractFruits(String fruitName, int fruitsNumber) {
        checkInput(fruitName, fruitsNumber);

        if (!fruitsStorage.containsKey(fruitName)) {
            throw new RuntimeException("There is no such fruit in the storage!");
        }
        int newStock = fruitsStorage.get(fruitName) - fruitsNumber;
        if (newStock < 0) {
            throw new RuntimeException("Storage does not have so many fruits!");
        }
        fruitsStorage.put(fruitName, newStock);
    }

    public static int getFruitsBalance(String fruitName) {
        return fruitsStorage.get(fruitName);
    }

    public static void setFruitBalance(String fruitName, int fruitsNumber) {
        checkInput(fruitName, fruitsNumber);
        fruitsStorage.put(fruitName, fruitsNumber);
    }

    public static Map<String, Integer> getFruits() {
        return fruitsStorage;
    }

    private static void checkInput(String fruitName, int fruitsNumber) {
        if (fruitsNumber < 0 || fruitName == null) {
            throw new RuntimeException("Incorrect input data!");
        }
    }
}
