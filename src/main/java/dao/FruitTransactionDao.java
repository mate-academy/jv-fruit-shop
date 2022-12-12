package dao;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionDao {
    boolean addAll(List<FruitTransaction> fruitTransactions);

    List<FruitTransaction> getAll();
}
