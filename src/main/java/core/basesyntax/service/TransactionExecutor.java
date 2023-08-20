package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface TransactionExecutor {
    void execute(List<FruitTransaction> fruitTransactionList);
}
