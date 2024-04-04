package dao;

import db.Storage;
import model.FruitTransaction;

public class TransactionDaoImpl implements TransactionDao {

    @Override
    public void addTransaction(FruitTransaction transaction) {
        Storage.transactions.add(transaction);
    }

    @Override
    public void getTransaction(FruitTransaction transaction) {
        Storage.transactions.get(0);
    }
}
