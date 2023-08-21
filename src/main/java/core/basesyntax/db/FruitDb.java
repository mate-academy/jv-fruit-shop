package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitDb {
    private static Map<String, Integer> balanceMap = new HashMap<>();

    public static Map<String, Integer> getBalanceMap() {
        return balanceMap;
    }

    public static void setBalanceMap(Map<String, Integer> balanceMap) {
        FruitDb.balanceMap = balanceMap;
    }
}
