package db;

import model.Fruit;

import java.util.HashSet;
import java.util.Set;

public class Storage {
    private final Set<Fruit> fruitsInStorage = new HashSet<>();

    public Set<Fruit> getFruitsInStorage() {
        return fruitsInStorage;
    }
}
