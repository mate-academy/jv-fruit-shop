package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

import java.util.List;
import java.util.Map;

public interface FruitTransactionHandler {
    void handle(Map<String, Integer> fruits, List<FruitTransaction> fruitTransactions);
}
