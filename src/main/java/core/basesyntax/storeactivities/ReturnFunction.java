package core.basesyntax.storeactivities;

import java.util.HashMap;

public class ReturnFunction implements StoreFunction {
    @Override
    public void action(HashMap<String, Integer> hashMap, String key, Integer value) {
        Integer integer = hashMap.get(key) + value;
        hashMap.put(key, integer);
    }
}

