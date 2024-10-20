package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface FruitTransactionDao {
    List<FruitTransaction> readTransaction(String filename);
    void writeReport(String filename, String report);
}
