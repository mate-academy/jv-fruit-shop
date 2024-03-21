package core.basesyntax.service;

import core.basesyntax.dto.Transaction;
import java.util.List;

public interface TransactionProcessor {
    void process(List<Transaction> transactions);
}
