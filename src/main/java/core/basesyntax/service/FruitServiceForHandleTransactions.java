package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitServiceForHandleTransactions {
    void handle(List<FruitTransaction> fruitTransactions);
}
