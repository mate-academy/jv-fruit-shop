package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface Shop<T extends Transaction> {
    void processTransactions(List<? extends T> transaction);

    String getReportData();
}
