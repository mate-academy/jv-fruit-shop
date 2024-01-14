package core.basesyntax.strategy.handler;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface TransactionHandler {
    void proceed(Map<String, Integer> map, FruitTransaction transaction);
}
