package core.basesyntax.Dao;

import core.basesyntax.Model.FruitTransaction;
import java.util.List;

public interface FruitDao {
    void add(FruitTransaction transaction);
    List<FruitTransaction> getFirst(String operation);
    List<FruitTransaction> get(String operation, String fruit);
}
