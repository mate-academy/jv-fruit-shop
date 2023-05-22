package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ProductDao {

    void update(FruitTransaction fruitTransaction, int count);

    int getQuantityOf(FruitTransaction fruitTransaction);

    List<String> getAll();
}
