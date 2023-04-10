package core.basesyntax.service;

import java.util.Map;

public interface CheckPositiveBalanceService {
    boolean isPositive(Map<String, Integer> fruitTransactionList);
}
