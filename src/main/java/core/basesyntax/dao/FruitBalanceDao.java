package core.basesyntax.dao;

import core.basesyntax.model.FruitBalance;
import java.util.List;

public interface FruitBalanceDao {
    void add(FruitBalance fruitBalance);

    List<FruitBalance> get();
}
