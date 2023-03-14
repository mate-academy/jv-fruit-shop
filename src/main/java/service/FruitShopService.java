package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitShopService {
    void startFruitsOperations(List<FruitTransaction> transactions);
}
