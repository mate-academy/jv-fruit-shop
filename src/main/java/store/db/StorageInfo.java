package store.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import store.model.Fruits;

public class StorageInfo implements StorageAble {
    private Map<Actions, List<Fruits>> db;

    public StorageInfo() {
        db = new HashMap<>();
    }

    @Override
    public void add(Actions key, Fruits value) {
        if (db.containsKey(key)) {
            List<Fruits> fruits = db.get(key);
            boolean isSame = false;
            for (int i = 0; i < fruits.size(); i++) {
                if (fruits.get(i).getName().equals(value.getName())) {
                    int cost = fruits.get(i).getCost() + value.getCost();
                    value.setCost(cost);
                    fruits.set(i, value);
                    isSame = true;
                    break;
                }
            }
            if (!isSame) {
                fruits.add(value);
            }
        } else {
            List<Fruits> fruits = new ArrayList<>();
            fruits.add(value);
            db.put(key, fruits);
        }
    }

    public Map<Actions, List<Fruits>> getDb() {
        return db;
    }
}
