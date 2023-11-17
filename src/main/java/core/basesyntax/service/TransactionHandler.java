package core.basesyntax.service;

import core.basesyntax.model.ItemTransaction;
import java.util.List;

public interface TransactionHandler {
    void handle(List<ItemTransaction> itemTransactions);
}
