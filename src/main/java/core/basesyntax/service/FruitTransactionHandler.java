package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionHandler {
    void handleFruitTransactions(List<FruitTransaction> fruitTransactions);
}
