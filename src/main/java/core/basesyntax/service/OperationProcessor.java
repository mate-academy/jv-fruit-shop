package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface OperationProcessor {
    void process(List<Transaction> transactionList);
}
