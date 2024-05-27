package core.basesyntax.db;

import java.util.List;

public interface FruitShopDao {
    void clearReportFile(String fileName);

    List<String> getFromFile(String fromFileName);

    List<String> getFruits(List<String> fromFile);

    List<String> calculate(List<String> fruitList, List<String> fromFile, String activities);

    void reportFruitsToNewFile(List<String> fruits, List<Integer> fruitAmount, String toFileName);
}
