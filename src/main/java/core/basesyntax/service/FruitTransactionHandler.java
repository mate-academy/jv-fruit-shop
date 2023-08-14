package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionHandler {
    void processTransactionsList(List<FruitTransaction> fruitTransactionList);
}
