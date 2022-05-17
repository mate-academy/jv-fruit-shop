package mate.academy.dao;

import java.util.List;
import mate.academy.model.FruitTransaction;

public interface FruitDao {
    void add(FruitTransaction fruitTransaction);

    FruitTransaction get(String fruitName);

    List<FruitTransaction> getAll();
}
