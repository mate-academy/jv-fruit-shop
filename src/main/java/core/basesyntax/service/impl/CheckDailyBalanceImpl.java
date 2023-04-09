package core.basesyntax.service.impl;

import core.basesyntax.service.CheckDailyBalance;
import java.util.Map;

public class CheckDailyBalanceImpl implements CheckDailyBalance {

    @Override
    public boolean isOk(Map<String, Integer> dailyBalance) {
        for (Map.Entry<String, Integer> entry : dailyBalance.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value < 0) {
                throw new RuntimeException("Something wrong with balance for " + key
                        + "\n It is negative.");
            }
        }
        return true;
    }
}
