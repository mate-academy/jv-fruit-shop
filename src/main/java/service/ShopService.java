package service;

import transaction.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ShopService {
    void process(List<FruitTransaction> transaction);
    Map<String, Integer> getStorage();
}
