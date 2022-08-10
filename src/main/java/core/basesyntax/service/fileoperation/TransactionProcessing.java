package core.basesyntax.service.fileoperation;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransactionProcessing {
    void transactionProcessing(List<Transaction> transactions);
}
