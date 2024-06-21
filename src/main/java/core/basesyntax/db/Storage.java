package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static final List<Fruit> fruits = new ArrayList<>();

    public static synchronized void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    public static synchronized List<Fruit> getFruits() {
        return new ArrayList<>(fruits);
    }

    public static synchronized void removeFruit(Fruit fruit) {
        fruits.remove(fruit);
    }
}
