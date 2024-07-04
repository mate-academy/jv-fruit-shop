package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<Fruit> fruits = new ArrayList<>();

    public void addFruitToStorage(String fruit, int quantity) {
        fruits.add(Fruit.of(fruit, quantity));
    }

    public Fruit getFruit(String fruit) {
        return fruits.stream()
                .filter(f -> f.getFruitName().equals(fruit))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Can't get a fruit from database" + fruit));
    }

    public void updateFruit(String fruit, int quantity) {
        Fruit receivedFruit = getFruit(fruit);
        receivedFruit.setQuantity(quantity);
    }

    public List<Fruit> getFruits() {
        return fruits;
    }
}
