package core.basesyntax.dao;

import java.util.List;

public interface TransactionDao {
    List<String> readFromFile(String fileName);
}
