package service;

import java.util.List;
import java.util.Map;
import transaction.FruitTransaction;

public interface ShopService {
    void process(List<FruitTransaction> transaction);

    Map<String, Integer> getStorage();
}
