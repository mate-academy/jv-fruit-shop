package dao;

import java.util.List;
import model.FruitTransaction;

public interface DatabaseDao {
    void addAllTransaction(List<FruitTransaction> fruitTransaction);

    List<FruitTransaction> getFruitTransaction();
}
