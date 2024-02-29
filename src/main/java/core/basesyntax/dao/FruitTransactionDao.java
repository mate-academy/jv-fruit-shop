package core.basesyntax.dao;

import java.util.List;

public interface FruitTransactionDao {
    List<String[]> getAllTransactions(String fileName);
}
