package service;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface ShopService {

    Map<String, Integer> processTransactions(List<FruitTransaction> transactions);
}
