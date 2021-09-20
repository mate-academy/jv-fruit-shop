package core.model;

import java.util.Map;

public class Storage {
    private Map<Fruit, Integer> fruitStorageMap;

    public Storage(Map<Fruit, Integer> fruitStorageMap) {
        this.fruitStorageMap = fruitStorageMap;
    }

    public Map<Fruit, Integer> getFruitStorageMap() {
        return fruitStorageMap;
    }
}
