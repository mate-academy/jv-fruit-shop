package core.basesyntax.service;

import java.util.Map;

public interface CheckDailyBalance {
    boolean isOk(Map<String, Integer> fruitTransactionList);
}
