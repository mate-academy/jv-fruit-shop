package dao;

import core.basesyntax.FruitTransaction;
import java.util.List;

public interface StorageDao {
    List<FruitTransaction> add(List<FruitTransaction> fruitTransaction);

    FruitTransaction get(int index);
}
