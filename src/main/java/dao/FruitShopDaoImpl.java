package dao;

import db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void save(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    @Override
    public Integer getValue(FruitTransaction fruitTransaction) {
        return Storage.fruits.get(fruitTransaction.getFruit());
    }

    @Override
    public List<FruitTransaction> getAll() {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setFruit(entry.getKey());
            fruitTransaction.setQuantity(entry.getValue());
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
