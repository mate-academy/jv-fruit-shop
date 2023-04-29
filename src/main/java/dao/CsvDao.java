package dao;

import java.util.List;
import java.util.Map;

public interface CsvDao {
    List<String> readFromFile(String filename);

    void writeToFile(Map<String, Integer> fruitTotalBalanceMap, String toFileName);
}
