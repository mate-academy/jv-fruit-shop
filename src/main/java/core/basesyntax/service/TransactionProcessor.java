package core.basesyntax.service;

import core.basesyntax.Storage;
import core.basesyntax.operation.Transaction;
import java.util.List;

public interface TransactionProcessor {
    void process(List<Transaction> operationsList, Storage storage);
}
