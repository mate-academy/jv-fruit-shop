package dao;

import java.util.List;
import model.FruitTransaction;

public interface DatabaseDao {
    void addTransaction(FruitTransaction fruitTransaction);

    List<FruitTransaction> getFruitTransaction();
}
