package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

import java.util.List;

public interface TransactionDao {
    void addFruits(String fruitTransaction, Integer quantity);

    Integer getFruits(String fruit);

    void addAll(List<FruitTransaction> fruitTransactions);
}
