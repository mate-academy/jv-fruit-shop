package services.actions;

import db.Storage;
import java.util.Map;

public class IncreaseHandler implements ActionHandler {
    @Override
    public Map<String, Integer> getResultOfAction(String fruitName, int fruitCount) {
        Storage.fruits.put(fruitName, Storage.fruits.getOrDefault(fruitName, 0) + fruitCount);
        return Storage.fruits;
    }
}
