package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.BiFunction;

public class Storage {
    private static final Map<String, Fruit> fruits = new HashMap<>();

    public void addFruitToStorage(String fruit, int quantity) {
        fruits.put(fruit, Fruit.of(fruit, quantity));
    }

    public Fruit getFruit(String fruit) {
        return Optional.of(fruits.get(fruit)).orElseThrow(() ->
                new NoSuchElementException("Can't get fruit by name" + fruit));
    }

    public void updateFruit(String fruit, int quantity) {
        BiFunction<Fruit, Fruit, Fruit> remappingFunction = (oldValue, newValue) -> {
            oldValue.setQuantity(oldValue.getQuantity() + newValue.getQuantity());
            if (oldValue.getQuantity() < 0) {
                throw new RuntimeException("Quantity can't be less than 0. Actual quantity for "
                        + oldValue.getFruitName() + " is " + oldValue.getQuantity());
            }
            return oldValue;
        };
        fruits.merge(fruit.toLowerCase(), Fruit.of(fruit, quantity), remappingFunction);
    }

    public Map<String, Fruit> getFruits() {
        return fruits;
    }
}
