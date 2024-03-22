package core.basesyntax.service;

import core.basesyntax.model.FruitsTransaction;
import java.util.List;

public interface TransactionProcessorService {
    void executeTransactions(List<FruitsTransaction> transactions);
}
