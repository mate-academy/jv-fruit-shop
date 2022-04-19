package dao;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionDao {
    void add(FruitTransaction fruitTransaction);

    List<FruitTransaction> getFruitTransactionList();
}
