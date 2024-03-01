package core.basesyntax.dao;

import core.basesyntax.entity.FruitTransaction;

import java.util.List;

public interface StoreCsvDao {
    void add(FruitTransaction fruitTransaction);
    List<FruitTransaction> getTransactionList(String transactionType);

    List<FruitTransaction> getAll();
}
