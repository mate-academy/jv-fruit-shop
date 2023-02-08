package core.basesyntax.dao;

import core.basesyntax.entity.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FruitsDao {

    void addListFruitsStorage(FruitTransaction stringListFruits);

    List<FruitTransaction> getAllListFruits(String fruit);

    Map<String, List<FruitTransaction>> getMapFruitByActivity(String fruits);

}
