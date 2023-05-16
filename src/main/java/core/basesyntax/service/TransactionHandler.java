package core.basesyntax.service;

import java.util.List;

public interface TransactionHandler {
    void handle(List<FruitTransaction> fruitTransactions);
}
