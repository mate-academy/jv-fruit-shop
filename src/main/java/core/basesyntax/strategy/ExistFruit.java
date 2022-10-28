package core.basesyntax.strategy;

import java.util.Map;

public interface ExistFruit {
    default boolean existFruit(Map<String, Integer> dataForReport, String fruit) {
        return !dataForReport.containsKey(fruit);
    }
}
