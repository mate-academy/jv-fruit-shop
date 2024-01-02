package core.basesyntax.db;

import java.util.Map;

public interface FruitDao {

    Integer getFruitBalance(String fruitName);

    Integer addFruits(String fruitName, int quantity);

    Integer subtractFruits(String fruitName, int quantity);

    Map<String, Integer> getDataBaseContent();
}
