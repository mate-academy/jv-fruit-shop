package db;

import java.util.Map;

public class Storage {
    private Map<String, Integer> fruitBox;

    public Storage(Map<String, Integer> fruitBox) {
        this.fruitBox = fruitBox;
    }

    public Map<String, Integer> getFruitBox() {
        return fruitBox;
    }
}
