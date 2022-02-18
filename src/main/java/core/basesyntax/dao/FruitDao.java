package core.basesyntax.dao;

import java.util.List;

public interface FruitDao {

    void updateStorage(List<String[]> data);

    String getDataFromStorage();
}
