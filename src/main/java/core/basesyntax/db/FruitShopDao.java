package core.basesyntax.db;

import java.util.List;

public interface FruitShopDao {

    List<String> getFromFile(String fromFileName);

    List<String> getFruits(List<String> fromFile);

    List<String> calculate(List<String> fruitList, String activities);
}
