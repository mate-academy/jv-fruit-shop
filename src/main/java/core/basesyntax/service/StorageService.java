package core.basesyntax.service;

import core.basesyntax.dto.Fruit;
import core.basesyntax.dto.Operation;
import core.basesyntax.exceptions.AlreadyHaveItException;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class StorageService {
    private final HashMap<String, Integer> storageMap = new HashMap<>();

    public void create(Fruit fruit, Operation operation) throws AlreadyHaveItException {
        if (storageMap.containsKey(fruit.getName())) {
            throw new AlreadyHaveItException("This fruit already exists in storage!");
        }
        storageMap.put(fruit.getName(), operation.getQuantity());
    }

    public int read(Fruit fruit) {
        if (!storageMap.containsKey(fruit.getName())) {
            throw new NoSuchElementException("Storage does not contain this kind of fruit!");
        }
        return storageMap.get(fruit.getName());
    }

    public void update(Fruit fruit, Integer value) {
        if (!storageMap.containsKey(fruit.getName())) {
            throw new NoSuchElementException("Storage does not contain this kind of fruit!");
        }
        storageMap.put(fruit.getName(), value);
    }

    public HashMap<String, Integer> getStorageMap() {
        return storageMap;
    }
}
