package dao;

import java.util.List;
import model.FruitTransaction;

public interface FruitDao {
    void add(FruitTransaction fruitTransaction);

    FruitTransaction get(String fruitName);

    List<FruitTransaction> getAll();
}
