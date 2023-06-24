package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface TransactionProcessor {
    void process(List<FruitTransaction> transactions, Map<String, Integer> fruits);
}
