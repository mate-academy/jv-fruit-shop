package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class FruitsStorage {
    private static Map<String, Integer> fruitsBalance = new HashMap<>();

    public static Map<String, Integer> accessFS() {
        return fruitsBalance;
    }
}

