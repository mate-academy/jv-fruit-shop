package core.basesyntax.managing.storage;

import java.util.Map;

public interface HandleGoods {
    void handleGoods(Map<String, Integer> storage, String fruitType, Integer amount);
}
