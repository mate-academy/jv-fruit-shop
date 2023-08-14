package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.math.BigDecimal;
import java.util.List;

public interface FruitTransactionDao {
    void add(FruitTransaction fruitTransaction);

    FruitTransaction get(String fruitName, BigDecimal quantity);

    List<FruitTransaction> getAll();
}
