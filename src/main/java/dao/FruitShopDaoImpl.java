package dao;

import db.Storage;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public List<FruitTransaction> get(String fruit) {
        return Storage.transactions.stream()
                .filter(t -> t.getFruit().equals(fruit))
                .collect(Collectors.toList());
    }

    @Override
    public List<FruitTransaction> getAll() {
        return Storage.transactions;
    }

    @Override
    public void add(FruitTransaction newTransaction) {
        Storage.transactions.add(newTransaction);
    }
}
