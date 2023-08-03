package core.basesyntax.dao;

import java.util.HashMap;

public interface ShopDao {
    void readFromFile(String addressFile);

    void writeToFile(HashMap<String,Integer> dataMap, String filePath);
}
