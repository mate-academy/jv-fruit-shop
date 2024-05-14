package dao;

import java.util.Map;

public interface FruitShopDao {
    int getBalanceByFruit(String fruit);

    Map<String, Integer> getBalance();

    void putBalanceStatistic(String fruit, Integer quantity);
}
