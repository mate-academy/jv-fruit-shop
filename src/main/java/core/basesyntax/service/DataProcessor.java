package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface DataProcessor {
    void processData(List<FruitTransaction> fruitTransactions);
}
