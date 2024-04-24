package core.basesyntax.service;

import core.basesyntax.operation.Transaction;
import java.util.List;
import java.util.Map;

public interface TransactionProcessor {
    Map<String, Integer> process(List<Transaction> operationsList);
}
