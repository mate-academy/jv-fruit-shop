package core.basesyntax.service;

import core.basesyntax.service.implementations.FruitTransaction;
import java.util.List;

public interface DataProcessor {
    void processData(List<FruitTransaction> fruitTransaction);
}
