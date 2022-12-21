package core.basesyntax.storage;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static Map<String, Integer> fruitMap = new HashMap<>();

    public static Map<String, Integer> getShopReport() {
        return shopReport;
    }

    public static void putShopReport(String fruit, Integer value) {
        shopReport.put(fruit, value);
    }
}
