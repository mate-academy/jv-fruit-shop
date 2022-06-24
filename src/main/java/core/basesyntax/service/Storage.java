package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface Storage {
    void fillStorage(List<FruitTransaction> fruitTransactions);
}
