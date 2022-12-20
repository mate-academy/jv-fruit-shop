package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FruitsDao {
    List<FruitTransaction> readDataFromFruitsCsv(String fromFileName);

    void writeReportToCsvFile(String toFileName);
}
