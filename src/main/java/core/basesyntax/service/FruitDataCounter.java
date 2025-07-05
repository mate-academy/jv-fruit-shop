package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitDataCounter {
    void fruitsCounter(List<FruitTransaction> fruitTransactions);
}
