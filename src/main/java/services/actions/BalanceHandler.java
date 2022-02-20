package services.actions;

import db.Storage;
import java.util.Map;

public class BalanceHandler implements ActionHandler {
    @Override
    public Map<String, Integer> getResultOfAction(String fruitName, int fruitCount) {
        Storage.fruits.put(fruitName, fruitCount);
        return Storage.fruits;
    }
}
