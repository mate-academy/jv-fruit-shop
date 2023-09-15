package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitDao {
    void writeToFile(String report);

    List<FruitTransaction> readFromFileToArray();
}
