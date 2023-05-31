package core.basesyntax.services;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface TransactionService {
    List<FruitTransaction> transactionProcessor(String fromFile);
}
