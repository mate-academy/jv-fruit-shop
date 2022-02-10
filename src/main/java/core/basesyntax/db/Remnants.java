package core.basesyntax.db;

import core.basesyntax.model.Fruit;

import java.util.HashMap;
import java.util.Map;

public class Remnants {
    private Map<Fruit, Integer> remnants;

    public Remnants() {
        this.remnants = new HashMap<>();
    }

    public void registerRemnants(Fruit fruit, int quantity) {
        remnants.put(fruit, quantity);
    }
}
