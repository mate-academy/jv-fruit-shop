package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitsDao {
    List<FruitTransaction> getFruitsData(String fromFile);

    void writeToFile(String fruitReport, String toFile);
}
