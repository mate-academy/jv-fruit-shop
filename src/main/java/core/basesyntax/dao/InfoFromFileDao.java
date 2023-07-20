package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface InfoFromFileDao {
    List<FruitTransaction> getAllTransactionsFromFile(String fileName);
}
