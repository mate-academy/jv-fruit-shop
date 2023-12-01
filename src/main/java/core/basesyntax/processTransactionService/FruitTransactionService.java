package core.basesyntax.processTransactionService;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitTransactionService {
    void processTransaction(List<FruitTransaction> transactionList);

}
