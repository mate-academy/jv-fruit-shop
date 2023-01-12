package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public interface TransactionProcessorService {
    void process(FruitTransaction transaction, Map<String, Integer> fruits);
}
