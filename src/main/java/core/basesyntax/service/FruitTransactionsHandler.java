package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionsHandler {
    void handle(List<FruitTransaction> fruitTransactions);
}
