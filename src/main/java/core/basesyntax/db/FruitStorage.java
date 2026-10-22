package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FruitStorage {
    private final List<Fruit> fruits = new ArrayList<>();

    public List<Fruit> getFruits() {
        return List.copyOf(fruits);
    }

    public void add(Fruit fruit) {
        fruits.add(fruit);
    }

    public Optional<Fruit> get(String name) {
        return fruits.stream()
                .filter(f -> Objects.equals(f.getName(), (name)))
                .findFirst();
    }

    public void update(String fruitName, int quantity) {
        Optional<Fruit> optionalFruit = get(fruitName);

        if (optionalFruit.isPresent()) {
            Fruit fruit = optionalFruit.get();
            fruit.setQuantity(quantity);
        } else {
            Fruit newFruit = new Fruit();
            newFruit.setName(fruitName);
            newFruit.setQuantity(quantity);

            fruits.add(newFruit);
        }
    }
}
