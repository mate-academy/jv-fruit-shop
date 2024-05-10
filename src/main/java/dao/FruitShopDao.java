package dao;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public interface FruitShopDao {
    List<FruitTransaction> getAll();

    void add(FruitTransaction newTransaction);

    public int getBalanceByFruit(String fruit);

    public Map<String, Integer> getBalance();

    void putBalanceStatistic(String fruit, Integer quantity);
}
