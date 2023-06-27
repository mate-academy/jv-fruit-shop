package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransactionReport;
import java.util.List;

public interface FruitTransactionService {
    void registerSingleTransaction(FruitTransaction fruitTransaction);

    void registerAllTransactions(List<FruitTransaction> fruitTransactions);

    FruitTransactionReport generateReport();
}
