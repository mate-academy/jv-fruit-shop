package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruitsTypeAndAmount = new HashMap<>();

    public static Map<String, Integer> getFruitsTypeAndAmount() {
        return fruitsTypeAndAmount;
    }

    public static void setFruitsTypeAndAmount(Map<String, Integer> fruitsTypeAndAmount) {
        Storage.fruitsTypeAndAmount = fruitsTypeAndAmount;
    }
}
