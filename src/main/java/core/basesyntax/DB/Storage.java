package core.basesyntax.DB;

import java.util.HashMap;
import java.util.Map;
import core.basesyntax.model.FruitTransaction;

public class Storage {
    private Map<String, Integer> storage = new HashMap<>();

//   public List<Fruit> getStorage() {
//        return storage;
//    }

    public void add(FruitTransaction fruit, int quantity) {
        if (storage.containsKey(fruit)) {
            throw new RuntimeException("This fruit is already present, please use supply operation");
        }
        storage.put(String.valueOf(fruit), quantity);
    }

    public void setFruitLeftover(String fruit, int quantity) {
        storage.put(fruit, quantity);
    }
}
