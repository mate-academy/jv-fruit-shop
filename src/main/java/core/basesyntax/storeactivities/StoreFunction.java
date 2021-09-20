package core.basesyntax.storeactivities;

import java.util.HashMap;

public interface StoreFunction {
    void action(HashMap<String, Integer> hashMap, String key, Integer value);

    enum StoreOperations {
        b,
        s,
        p,
        r
    }
}
