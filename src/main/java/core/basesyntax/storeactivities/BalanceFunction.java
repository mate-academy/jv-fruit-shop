package core.basesyntax.storeactivities;

import java.util.HashMap;

public class BalanceFunction implements StoreFunction {
    @Override
    public void action(HashMap<String, Integer> hashMap, String key, Integer value) {
        hashMap.put(key, value);
    }
}
