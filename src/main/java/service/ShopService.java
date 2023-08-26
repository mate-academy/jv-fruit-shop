package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface ShopService {
    void getRepport(List<FruitTransaction> from, Map<String,Integer> to);
}
