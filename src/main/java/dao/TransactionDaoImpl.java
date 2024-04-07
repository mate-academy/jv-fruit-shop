package dao;

import db.Storage;
import model.FruitTransaction;

import java.util.List;

public class TransactionDaoImpl implements TransactionDao {

    @Override
    public void addTransaction(FruitTransaction transaction) {
        Storage.transactions.add(transaction);
    }

    @Override
    public List<FruitTransaction> getTransaction() {
       return Storage.transactions;
    }
}
