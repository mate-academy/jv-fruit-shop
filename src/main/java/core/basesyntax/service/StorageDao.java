package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;
import java.util.Set;

public interface StorageDao {

    public void set(Fruit fruit, Integer amount);

    public void add(Fruit fruit, Integer amount);

    public void reduce(Fruit fruit, Integer amount);

    public Integer get(Fruit fruit);

    public Set<Map.Entry<Fruit, Integer>> getAll();
}
