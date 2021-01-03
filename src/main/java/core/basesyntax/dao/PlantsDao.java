package core.basesyntax.dao;

import java.util.List;

public interface PlantsDao {
    void setData(List<String> data);

    List<String> getData();
}
