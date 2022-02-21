package db;

import java.util.HashSet;
import java.util.Set;
import model.Fruit;

public class Storage {
    private final Set<Fruit> fruitsInStorage = new HashSet<>();

    public Set<Fruit> getFruitsInStorage() {
        return fruitsInStorage;
    }
}
