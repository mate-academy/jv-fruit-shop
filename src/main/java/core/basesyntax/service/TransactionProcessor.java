package core.basesyntax.service;

import java.util.List;

public interface TransactionProcessor {
    void process(List<String> transactions);
}
