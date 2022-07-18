package core.basesyntax.dao;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransactionDao {
    List<Transaction> getAll(String fileName);

    void add(Transaction transaction);
}
