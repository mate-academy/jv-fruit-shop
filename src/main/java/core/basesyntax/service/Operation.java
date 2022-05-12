package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Operation {
    void process(List<FruitTransaction> fruitTransactions);
}
