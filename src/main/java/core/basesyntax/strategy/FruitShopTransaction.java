package core.basesyntax.strategy;

import java.util.Map;

public interface FruitShopTransaction {
    void fruitTransaction(Map<String, Integer> dataForReport,
                          String activityType, String fruit, int quantity);
}
