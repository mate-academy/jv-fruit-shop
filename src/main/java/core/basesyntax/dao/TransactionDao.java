package core.basesyntax.dao;

import core.basesyntax.model.Transaction;

import java.util.List;

public interface TransactionDao {
    public List<Transaction> get();
}
