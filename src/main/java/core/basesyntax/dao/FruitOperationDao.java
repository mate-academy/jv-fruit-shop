package core.basesyntax.dao;

import core.basesyntax.model.FruitReport;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitOperationDao {
    List<FruitTransaction> readFile();

    void writeToFile(List<FruitReport> report);
}
