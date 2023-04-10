package core.basesyntax.service.impl;

import core.basesyntax.service.CheckPositiveBalanceService;
import java.util.Map;

public class CheckPositiveBalanceServiceImpl implements CheckPositiveBalanceService {

    @Override
    public boolean isPositive(Map<String, Integer> balance) {
        for (Map.Entry<String, Integer> entry : balance.entrySet()) {
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
