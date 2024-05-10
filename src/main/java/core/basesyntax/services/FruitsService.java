package core.basesyntax.services;

import core.basesyntax.transactions.FruitsTransaction;
import java.util.List;

public interface FruitsService {
    void processTransactions(List<FruitsTransaction> transactions);

    String createReport();
}
