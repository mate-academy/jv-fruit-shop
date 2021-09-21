package service;

import java.util.List;
import java.util.Map;
import service.impl.Fruit;

public interface TransactionData {
    Map<Fruit, Integer> parseDataToMap(List<String> data, Map<Fruit, Integer> report);
}
