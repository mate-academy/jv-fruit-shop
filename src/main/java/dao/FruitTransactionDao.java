package dao;

import java.util.List;
import model.FruitTransaction;

public interface FruitTransactionDao {
    boolean add(FruitTransaction fruitTransaction);

    List<FruitTransaction> getAll();
}
