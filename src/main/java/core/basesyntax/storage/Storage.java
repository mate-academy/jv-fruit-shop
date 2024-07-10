package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Storage {
    private static final List<Fruit> fruits = new ArrayList<>();

    public void addFruitToStorage(String fruit, int quantity) {
        fruits.add(Fruit.of(fruit, quantity));
    }

    public Optional<Fruit> getFruit(String fruit) {
        return fruits.stream()
                .filter(f -> f.getFruitName().equals(fruit))
                .findFirst();
    }

    public void updateFruit(String fruit, int quantity) {
        Optional<Fruit> receivedFruit = getFruit(fruit);
        if (receivedFruit.isPresent()) {
            receivedFruit.get().setQuantity(quantity);
        } else {
            addFruitToStorage(fruit, quantity);
        }
    }

    public List<Fruit> getFruits() {
        return fruits;
    }
}
