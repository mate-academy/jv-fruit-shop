package dao;

import db.Storage;
import java.util.Map;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public int getBalanceByFruit(String fruit) {
        return Storage.balanceStatistic.get(fruit);
    }

    @Override
    public Map<String, Integer> getBalance() {
        return Storage.balanceStatistic;
    }

    @Override
    public void putBalanceStatistic(String fruit, Integer quantity) {
        Storage.balanceStatistic.put(fruit, quantity);
    }
}
