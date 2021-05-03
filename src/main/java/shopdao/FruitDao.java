package shopdao;

import fruitsassortment.Fruit;
import java.util.Map;

public interface FruitDao {
    boolean add(Fruit fruit, int amount);

    int get(Fruit fruit);

    Map<Fruit, Integer> getAll();
}
