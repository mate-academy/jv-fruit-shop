package db;

import java.util.*;

public class Storage {
    private HashMap<String,Integer> fruitQuantities;

    public Storage() {
        fruitQuantities = new HashMap<>();
    }

    public void addFruits(String fruit,Integer number) {
        fruitQuantities.put(fruit,number);
    }

    public Integer getFruitQuantities(String fruit) {
      return   fruitQuantities.getOrDefault(fruit,0);
    }
}
