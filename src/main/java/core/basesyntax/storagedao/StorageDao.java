package core.basesyntax.storagedao;

import core.basesyntax.model.Fruit;
import java.util.Map;

public interface StorageDao {
    void add(Fruit fruit, Integer amount);

    Map.Entry<Fruit, Integer> get(String name);

    boolean isInStorage(String name);

    Integer getQuantityByName(String name);

}
