package db;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;

public class FruitStorage {
    private final Map<String,Integer> fruitStock;

    public FruitStorage() {
        fruitStock = new HashMap<>();
    }

    public Fruit getFruit(String name) {
        if (fruitStock.get(name) == null) {
            throw new RuntimeException("There is no such fruit type " + name + " in storage");
        }
        Integer quantity = fruitStock.get(name);
        if (quantity < 0) {
            throw new RuntimeException("Stored quantity can't be less than zero");
        }
        return new Fruit(name, quantity == null ? 0 : quantity);
    }

    public void setFruit(String name, Integer quantity) {
        fruitStock.put(name, quantity);
    }

    public void addFruitsToStock(String name, Integer quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Fruit quantity can't be less than zero");
        }
        Integer storedQuantity = fruitStock.get(name);
        if (storedQuantity == null) {
            storedQuantity = 0;
        }
        if (storedQuantity < 0) {
            throw new RuntimeException("Stored quantity can't be less than zero");
        }
        fruitStock.put(name, storedQuantity + quantity);
    }

    public void removeFruitsFromStock(String name, Integer quantity) {
        if (fruitStock.get(name) == null) {
            throw new RuntimeException("There is no such fruit type " + name + " in storage");
        }
        Integer storedQuantity = fruitStock.get(name);
        if (storedQuantity == null) {
            storedQuantity = 0;
        }
        Integer resultQuantity = storedQuantity - quantity;
        if (resultQuantity < 0) {
            throw new RuntimeException("Stored quantity can't be less than zero");
        } else if (resultQuantity == 0) {
            fruitStock.remove(name);
        } else {
            fruitStock.put(name, resultQuantity);
        }
    }

    public Map<String, Integer> getFruitStock() {
        return fruitStock;
    }
}
