package dao;

import db.Storage;
import java.util.Map;
import model.Fruit;

public class FruitStorageDaoImpl implements FruitStorageDao {
    private static final int MIN_QUANTITY = 0;
    private final Map<String,Integer> fruitStock = Storage.FRUITS;

    @Override
    public Fruit getFruit(String name) {
        if (fruitStock.get(name) == null) {
            throw new RuntimeException("There is no such fruit type " + name + " in storage");
        }
        Integer quantity = fruitStock.get(name);
        if (quantity < MIN_QUANTITY) {
            throw new RuntimeException("Stored quantity can't be less than zero");
        }
        return new Fruit(name, quantity == null ? MIN_QUANTITY : quantity);
    }

    @Override
    public void set(String name, Integer quantity) {
        fruitStock.put(name, quantity);
    }

    @Override
    public void add(String name, Integer quantity) {
        if (quantity < MIN_QUANTITY) {
            throw new RuntimeException("Fruit quantity can't be less than zero");
        }
        Integer storedQuantity = fruitStock.get(name);
        if (storedQuantity == null) {
            storedQuantity = MIN_QUANTITY;
        }
        if (storedQuantity < MIN_QUANTITY) {
            throw new RuntimeException("Stored quantity can't be less than zero");
        }
        fruitStock.put(name, storedQuantity + quantity);
    }

    @Override
    public void remove(String name, Integer quantity) {
        if (fruitStock.get(name) == null) {
            throw new RuntimeException("There is no such fruit type " + name + " in storage");
        }
        Integer storedQuantity = fruitStock.get(name);
        if (storedQuantity == null) {
            storedQuantity = MIN_QUANTITY;
        }
        Integer resultQuantity = storedQuantity - quantity;
        if (resultQuantity < MIN_QUANTITY) {
            throw new RuntimeException("Stored quantity can't be less than zero");
        } else if (resultQuantity == MIN_QUANTITY) {
            fruitStock.remove(name);
        } else {
            fruitStock.put(name, resultQuantity);
        }
    }

    @Override
    public Map<String, Integer> getFruits() {
        return fruitStock;
    }
}
