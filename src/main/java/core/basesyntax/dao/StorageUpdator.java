package core.basesyntax.dao;

import core.basesyntax.dao.transaction.FruitTransaction;

import java.util.List;

public interface StorageUpdator {
    void updateStorage(List<FruitTransaction> fruitTransactionList);
}
