package core.basesyntax.dao;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface StorageDao {
    void add(Transaction transaction);

    void addList(List<Transaction> transactions);

    List<Transaction> getTransactions();
}
