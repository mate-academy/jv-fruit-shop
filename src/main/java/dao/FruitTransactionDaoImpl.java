package dao;

import database.Storage;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class FruitTransactionDaoImpl implements FruitTransactionDao {

    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruitTransactionStorage.add(fruitTransaction);
    }

    @Override
    public List<FruitTransaction> getFruitTransactionList() {
        return new ArrayList<>(Storage.fruitTransactionStorage);
    }
}
