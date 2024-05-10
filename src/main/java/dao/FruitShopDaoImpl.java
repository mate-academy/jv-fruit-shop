package dao;

import db.Storage;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public List<FruitTransaction> getAll() {
        return Storage.transactions;
    }

    @Override
    public void add(FruitTransaction newTransaction) {
        Storage.transactions.add(newTransaction);
    }

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
