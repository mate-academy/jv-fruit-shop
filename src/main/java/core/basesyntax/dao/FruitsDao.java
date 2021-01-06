package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitsDao {
    void setData(List<Fruit> fruits);

    List<Fruit> getData();
}
