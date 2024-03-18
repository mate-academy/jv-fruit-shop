package service;

import java.util.List;
import model.FruitTransaction;

public interface FruitShopService {
    void getFruitBalance(List<FruitTransaction> fruitTransactions);
}
