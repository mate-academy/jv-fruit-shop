package core.basesyntax.dao;

import java.util.List;

public interface FruitsDao {
    void setData(List<String> data);

    List<String> getData();
}
