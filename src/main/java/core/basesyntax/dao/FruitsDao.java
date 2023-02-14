package core.basesyntax.dao;

import core.basesyntax.entity.FruitTransaction;
import java.util.List;

public interface FruitsDao {
    void addFruitsStorage(FruitTransaction stringListFruits);

    List<FruitTransaction> getAllListFruits(String fruit);
}
