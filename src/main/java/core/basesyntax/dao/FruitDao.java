package core.basesyntax.dao;

import java.util.List;

public interface FruitDao {
    void writeToStorage(List<String> information);

    String generateReport();
}
