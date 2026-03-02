package core.basesyntax.dao;

import java.util.Map;

public interface FruitDao {
    void addFruit(String fruitName, int fruitAmount);

    Integer getFruit(String fruit);
}
