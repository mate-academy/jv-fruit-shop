package db;

import java.util.List;
import java.util.Map;
import model.Activity;
import strategy.ActivityTypeStrategy;
import strategy.impl.ActivityTypeStrategyImpl;

public class Storage {
    private final Map<String, Integer> fruitBox;

    public Storage(Map<String, Integer> fruitBox) {
        this.fruitBox = fruitBox;
    }

    public Map<String, Integer> getFruitBox() {
        return fruitBox;
    }
}
