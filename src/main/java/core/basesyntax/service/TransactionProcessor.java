package core.basesyntax.service;

import core.basesyntax.model.ShopTransaction;
import java.util.List;

public interface TransactionProcessor {
    void process(List<ShopTransaction> shopTransactions);
}
