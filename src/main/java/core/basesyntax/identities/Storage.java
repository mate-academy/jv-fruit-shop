package core.basesyntax.identities;

import java.util.*;

public class Storage {
    private Map<String, List<Fruit>> fruits;

    public Storage() {
        this.fruits = new HashMap<>();
    }

    public Map<String, List<Fruit>> getFruits() {
        return fruits;
    }

    public boolean addFruit(Fruit fruit) {
        if (!fruits.containsKey(fruit.getType())) {
            fruits.put(fruit.getType(), new ArrayList<>());
        }
        fruits.get(fruit.getType()).add(fruit);
        return true;
    }

    public boolean removeFruit(Fruit fruit) {
        if (fruits.containsKey(fruit.getType())) {
            fruits.get(fruit.getType()).remove(fruit);
        } else {
            throw new NoSuchElementException("There is no " + fruit.getType());
        }
        return true;
    }

    public Map<String, Integer> currentAmountOfEachTypeOfFruit() {
        Map<String, Integer> output = new HashMap<>();
        for (Map.Entry<String, List<Fruit>> entry : fruits.entrySet()) {
            output.put(entry.getKey(), entry.getValue().size());
        }
        return output;
    }
}
