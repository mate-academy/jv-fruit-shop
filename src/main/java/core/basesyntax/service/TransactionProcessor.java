package core.basesyntax.service;

import core.basesyntax.storage.Storage;
import core.basesyntax.transaction.Transaction;
import java.util.List;

public interface TransactionProcessor {
    void process(List<Transaction> operationsList, Storage storage);
}
