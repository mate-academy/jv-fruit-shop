package core.basesyntax.fruit;

import java.util.Map;
import java.util.TreeMap;

public class Fruits {
    private Map<String, Integer> fruits;

    public Fruits() {
        fruits = new TreeMap<>();
    }

    public Map<String, Integer> getFruits() {
        return fruits;
    }
}
