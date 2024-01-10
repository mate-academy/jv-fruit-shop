package core.basesyntax.db;

import java.util.Map;

public interface FruitDao {

    Integer setFruitBalance(String fruitName, int quantity);

    Integer getFruitBalance(String fruitName);

    Integer addFruits(String fruitName, int quantity);

    Map<String, Integer> getDataBaseContent();
}
