package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface FruitShopService {
    List<String> fileReader(String filePath);

    void fileWriter(List<String> statistic, String filePath);

    FruitTransaction parseStringToTransaction(String inputString);

    List<String> parseStatisticToString(Map<String, Integer> statistic);
}
