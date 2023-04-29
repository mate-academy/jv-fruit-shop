package service.impl;

import java.util.Map;

public class PositiveBalanceCheck {
    public static boolean check(Map<String, Integer> fruitStorageTotalBalance) {
        if (fruitStorageTotalBalance == null) {
            return false;
        }
        return fruitStorageTotalBalance
                .values().stream()
                .noneMatch(value -> value < 0);
    }
}
