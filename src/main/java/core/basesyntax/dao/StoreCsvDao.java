package core.basesyntax.dao;

import core.basesyntax.entity.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface StoreCsvDao {
    void addLine(FruitTransaction fruitTransaction);

    List<FruitTransaction> getAll();

    void saveReportToFile(Map<String,Integer> report);
}
