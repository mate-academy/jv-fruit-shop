package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;

public class Storage {
    private static final Map<String, Fruit> fruits = new HashMap<>();

    public void addFruitToStorage(String fruit, int quantity) {
        fruits.put(fruit, Fruit.of(fruit, quantity));
    }

    public Fruit getFruit(String fruit) {
        return Optional.of(fruits.get(fruit)).orElseThrow(() ->
                new RuntimeException("Can't get fruit by name" + fruit));
    }

    public void updateFruit(String fruit, int quantity) {
        BiFunction<Fruit, Fruit, Fruit> remappingFunction = (oldValue, newValue) -> {
            oldValue.setQuantity(newValue.getQuantity());
            return oldValue;
        };
        fruits.merge(fruit.toLowerCase(), Fruit.of(fruit, quantity), remappingFunction);
    }

    public Map<String, Fruit> getFruits() {
        return fruits;
    }
}
