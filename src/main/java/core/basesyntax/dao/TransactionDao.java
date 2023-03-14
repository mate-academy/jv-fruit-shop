package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionDao {
    void add(FruitTransaction transaction);
    void addAll(List<FruitTransaction> transactions);

    List<FruitTransaction> get(String fileName);
    void updateStock(String fruit, int amount);
}
