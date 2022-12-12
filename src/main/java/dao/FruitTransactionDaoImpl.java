package dao;

import db.Storage;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class FruitTransactionDaoImpl implements FruitTransactionDao {

    @Override
    public boolean addAll(List<FruitTransaction> fruitTransactions) {
        return Storage.transactions.addAll(fruitTransactions);
    }

    @Override
    public List<FruitTransaction> getAll() {
        return new ArrayList<>(Storage.transactions);
    }
}
