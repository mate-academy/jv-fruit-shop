package core.basesyntax.dao;

import java.util.List;

public interface FruitDao {
    void setData(List<String> data);

    List<String> getData();
}
