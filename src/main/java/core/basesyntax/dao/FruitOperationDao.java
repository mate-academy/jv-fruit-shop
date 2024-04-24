package core.basesyntax.dao;

import core.basesyntax.model.FruitReport;
import java.util.List;

public interface FruitOperationDao {
    List<String> readFile();

    void writeToFile(List<FruitReport> report);
}
