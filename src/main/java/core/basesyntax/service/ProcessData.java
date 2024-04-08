package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProcessData {
    void operation(List<FruitTransaction> fruitTransactions);
}
