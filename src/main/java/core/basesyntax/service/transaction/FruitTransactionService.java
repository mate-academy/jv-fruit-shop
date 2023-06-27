package core.basesyntax.service.transaction;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionService {
    void processSingleTransaction(FruitTransaction fruitTransaction);

    void processTransactions(List<FruitTransaction> fruitTransactions);
}
