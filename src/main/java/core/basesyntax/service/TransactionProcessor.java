package core.basesyntax.service;

import core.basesyntax.dto.ProductTransaction;
import java.util.List;

public interface TransactionProcessor {
    void process(List<ProductTransaction> productTransactions);
}
