package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface FruitShopService {
    Map<String, Integer> report(List<FruitTransaction> parsed);
}
