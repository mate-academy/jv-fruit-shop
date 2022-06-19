package core.basesyntax.Dao;

import core.basesyntax.model.Transaction;

import java.util.List;

public interface BalanceDao {
        List<Transaction> getBalanceFromFile(String fileName);
}
