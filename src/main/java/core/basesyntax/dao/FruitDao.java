package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitDao {

    void add(Fruit fruit);

    void update(Fruit fruit);

    Fruit get(String fruitName);

    List<String> getStorage();


    //void changeQuantityFruit(Fruit fruit, int quantity);
}
