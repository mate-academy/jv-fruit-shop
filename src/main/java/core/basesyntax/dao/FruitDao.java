package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitDao {
    void addCsvRow(Fruit fruitTransaction);

    List<String> getCsv();

    void updateCsv(List<String> updatedCsvData);
}
