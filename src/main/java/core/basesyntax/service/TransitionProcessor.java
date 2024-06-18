package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface TransitionProcessor {
    public void processTransaction(Map<String, Integer> balanceMap, FruitTransaction transaction);
}
