package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private static Storage instance;
    private final List<Fruit> fruits;

    private Storage() {
        fruits = new ArrayList<>();
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public List<Fruit> getStorage() {
        return fruits;
    }
}
