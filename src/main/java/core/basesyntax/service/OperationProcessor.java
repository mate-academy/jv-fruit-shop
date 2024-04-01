package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationProcessor {
    void process(List<FruitTransaction> fruitTransactions);
}
